package bonus.refactor.funhell;

import bonus.refactor.funhell.readonly.NoteCustom;

import bonus.refactor.funhell.readonly.DetailsF;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//@Slf4j
public abstract class XmlInputHandler extends DefaultHandler {

    public static final Bound<DetailsF> causaleBollettinoBound = new Bound<>((s, d) -> {
//        log.debug("Causale before replace [" + s + "]");
        d.setCausaleBollettino(s.replaceAll("(\n|\r\n)+", " "));
//        log.debug("Causale after replace [" + d.getCausaleBollettino() + "]");
    }, d -> d.setCausaleBollettinoModificabile(true));

    public static final String IMPORTO = "IMPORTO";
    public static final String LINE_LISTA = "LINE_LISTA";
    public static final String CAUSALE_BOLLETTINO = "CAUSALE_BOLLETTINO";

    public static final Map<String, Bound<DetailsF>> DET_MAV_MAP = ImmutableMap.<String, Bound<DetailsF>>builder()
            .put(IMPORTO, new Bound<>((s, d) -> d.setImporto(s), d -> d.setImportoModificabile(true)))
            .put("SCADENZA", new Bound<>((s, d) -> d.setScadenza(s), d -> d.setScadenzaModificabile(true)))
            .put("IDENTIFICATIVO_DISPOSIZIONE", new Bound<>((s, d) -> d.setIdentificativoDisposizione(s), d -> {}))// dont have modify flag
            .put(CAUSALE_BOLLETTINO, causaleBollettinoBound).build();

    public static final Map<String, Bound<NoteCustom>> AVVISO_MAP = ImmutableMap.<String, Bound<NoteCustom>>builder()
            .put("VAR_SIA", new Bound<>((s, a) -> a.setVARSia(s), a -> {}))// dont have modify flag
            .put("VAR_SERVIZIO", new Bound<>((s, a) -> a.setVARServizio(s), a -> {}))// dont have modify flag
            .put("VAR_SOTTOSERVIZIO", new Bound<>((s, a) -> a.setVARSottoservizio(s), a -> {}))// dont have modify flag
            .put(LINE_LISTA, new Bound<>((s, a) -> a.setLINELista(s), a -> a.setLINEListaModificabile(true)))
            .put("VAR_FISCALE_RUN", new Bound<>((s, a) -> a.setVARFiscaleRUN(s), a -> a.setVARFiscaleRUNModificabile(true)))
            .put("VAR_RUN", new Bound<>((s, a) -> a.setVARRUN(s), a -> a.setVARRUNModificabile(true)))
            .put("ANAGRAFICA_RUN", new Bound<>((s, a) -> a.setAnagraficaRUN(s), a -> a.setAnagraficaRUNModificabile(true)))
            .put("CONTINUAZIONE_ANAGRAFICA", new Bound<>((s, a) -> a.setContinuazioneAnagrafica(s), a -> a.setContinuazioneAnagraficaModificabile(true)))
            .put("INDIRIZZO_RUN", new Bound<>((s, a) -> a.setIndirizzoRUN(s), a -> a.setIndirizzoRUNModificabile(true)))
            .put("CAP_RUN", new Bound<>((s, a) -> a.setCapRUN(s), a -> a.setCapRUNModificabile(true)))
            .put("LOCALITA_RUN", new Bound<>((s, a) -> a.setLocalitaRUN(s), a -> a.setLocalitaRUNModificabile(true)))
            .put("PROVINCIA_RUN", new Bound<>((s, a) -> a.setProvinciaRUN(s), a -> a.setLocalitaRUNModificabile(true)))
            .put("EMAIL_RUN", new Bound<>((s, a) -> a.setEmailRUN(s), a -> a.setEmailRUNModificabile(true)))
            .build();

    public static final Bound<NoteCustom> DO_NOTHING_AVISO = new Bound<>((s, a) -> {}, a -> {});
    public static final Bound<DetailsF> DO_NOTHING_DET_MAV = new Bound<>((s, a) -> {}, a -> {});

    protected static final String TAG_IN_NOME_ATT_MODIFICABILE = "modificabile";
    private static final String L_ELEMENTO = "L'elemento [";

    protected String currentActivity;
    protected StringBuffer currentContent = null;

    public XmlInputHandler() {
        super();
    }

    public void characters(char[] ch, int start, int length) {
        currentContent.append(new String(ch, start, length));
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
        currentContent.append(new String(ch, start, length));
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentContent = new StringBuffer();
        String attribute = attributes.getValue(TAG_IN_NOME_ATT_MODIFICABILE);
        if (!isModificabileAttribute(attribute) || qName == null) {
            return;
        }
        currentActivity = qName.toUpperCase();
        Bound<NoteCustom> avvisoBound = AVVISO_MAP.getOrDefault(currentActivity, DO_NOTHING_AVISO);
        avvisoBound.accessOpener.accept(getNoteCustomMulti());
        Bound<DetailsF> dettagliMavBound = DET_MAV_MAP.getOrDefault(currentActivity, DO_NOTHING_DET_MAV);
        dettagliMavBound.accessOpener.accept(getDettaglio());
    }

    private boolean isModificabileAttribute(String attribute) {
        return attribute != null && attribute.toUpperCase().equals("S");
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName == null) {
            return;
        }
        currentActivity = qName.toUpperCase();
        if (currentActivity.equalsIgnoreCase(SpecActivities.ACQUISIZIONE_AVVISO.name())) {
//            log.debug("Controlli addizionali globali");
            if (getNoteCustomMulti().getLINELista() == null) {
                throw new SAXException(L_ELEMENTO + LINE_LISTA + "] deve essere presente");
            }
        }
        if (currentActivity.equalsIgnoreCase(SpecActivities.START_PAGAMENTO.name())) {
//            log.debug("Controlli addizionali");
            if (getDettaglio().getImporto() == null) {
                throw new SAXException(L_ELEMENTO + IMPORTO + "] deve essere presente");
            }
            if (getDettaglio().getCausaleBollettino() != null && getDettaglio().getCausaleBollettino().length() > 10) {
                throw new SAXException(L_ELEMENTO + CAUSALE_BOLLETTINO + "] ha lunghezza superiore alla massima consentita di " + 10 + " caratteri");
            }
        }
        String trimmedContent = currentContent.toString().trim();
//        log.debug("Current activity [" + qName + "] [" + currentContent + "]");

        Bound<NoteCustom> avvisoBound = AVVISO_MAP.getOrDefault(currentActivity, DO_NOTHING_AVISO);
        avvisoBound.setter.accept(trimmedContent, getNoteCustomMulti());
        Bound<DetailsF> dettagliMavBound = DET_MAV_MAP.getOrDefault(currentActivity, DO_NOTHING_DET_MAV);
        dettagliMavBound.setter.accept(trimmedContent, getDettaglio());
    }

    public abstract NoteCustom getNoteCustomMulti();

    public abstract DetailsF getDettaglio();

    enum SpecActivities {

        NOT_ACTIVE, START_PAGAMENTO, ACQUISIZIONE_AVVISO, PROGRESSIVO, LINE_DISPOSIZIONI;

        public static SpecActivities getOrDefault(String name) {
            try {
                return SpecActivities.valueOf(name);
            } catch (IllegalArgumentException e) {
//                log.error("Activity Tag unknown: {}", name );
                return NOT_ACTIVE;
            }
        }
    }

    static class Bound<T> {

        BiConsumer<String, T> setter;
        Consumer<T> accessOpener;

        public Bound(BiConsumer<String, T> setter, Consumer<T> accessOpener) {
            this.setter = setter;
            this.accessOpener = accessOpener;
        }
    }
}
