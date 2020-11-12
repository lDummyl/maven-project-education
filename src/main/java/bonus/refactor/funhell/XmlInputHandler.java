/*
package bonus.refactor.funhell;

import bonus.refactor.funhell.readonly.DetailsF;
import bonus.refactor.funhell.readonly.NoteCustom;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


*/
/**
 * Цель задания, без использования рефлешн и модификации классов в пакете readonly
 * данный класс избавить от cyclomatic complexity (SonarLint плагин для IDE)
 * и, если потребуется, доработать остальные классы в текущем пакете.
 * В идеале код этого класса в объеме сократится вдвое.
 * Логгеры закоменчены но это условность, они должны сохранится в логике.
 * Задача на рефактор, так что изменния повдеения должны быть минимальны.
 *
 * *//*




//@Slf4j
public abstract class XmlInputHandler extends DefaultHandler {

    public static final String TAG_IN_ACQUISIZIONE_AVVISO = "acquisizione_avviso";
    public static final String TAG_IN_LINE_DISPOSIZIONI = "LINE_disposizioni";
    public static final String TAG_IN_START_BANCA = "START_banca";
    public static final String TAG_IN_VAR_SIA = "VAR_sia";
    public static final String TAG_IN_VAR_SERVIZIO = "VAR_servizio";
    public static final String TAG_IN_VAR_SOTTOSERVIZIO = "VAR_sottoservizio";
    public static final String TAG_IN_LINE_LISTA = "LINE_lista";
    public static final String TAG_IN_START_RUN = "START_RUN";
    public static final String TAG_IN_VAR_FISCALE_RUN = "VAR_fiscale_RUN";
    public static final String TAG_IN_VAR_RUN = "VAR_RUN";
    public static final String TAG_IN_ANAGRAFICA_RUN = "anagrafica_RUN";
    public static final String TAG_IN_CONTINUAZIONE_ANAGRAFICA = "continuazione_anagrafica";
    public static final String TAG_IN_INDIRIZZO_RUN = "indirizzo_RUN";
    public static final String TAG_IN_CAP_RUN = "cap_RUN";
    public static final String TAG_IN_LOCALITA_RUN = "localita_RUN";
    public static final String TAG_IN_PROVINCIA_RUN = "provincia_RUN";
    public static final String TAG_IN_EMAIL_RUN = "email_RUN";
    public static final String TAG_IN_INVIO_PDF_RUN = "invio_pdf_RUN";
    public static final String TAG_IN_START_PAGAMENTO = "START_pagamento";
    public static final String TAG_IN_PROGRESSIVO = "progressivo";
    public static final String TAG_IN_IMPORTO = "importo";
    public static final String TAG_IN_SCADENZA = "scadenza";
    public static final String TAG_IN_IDENTIFICATIVO_DISPOSIZIONE = "identificativo_disposizione";
    public static final String TAG_IN_CAUSALE_BOLLETTINO = "causale_bollettino";
    protected static final short TAG_IN_ACQUISIZIONE_AVVISO_ID = 0;
    protected static final short TAG_IN_LINE_DISPOSIZIONI_ID = 1;
    protected static final short TAG_IN_START_BANCA_ID = 2;
    protected static final short TAG_IN_VAR_SIA_ID = 3;
    protected static final short TAG_IN_VAR_SERVIZIO_ID = 4;
    protected static final short TAG_IN_VAR_SOTTOSERVIZIO_ID = 5;
    protected static final short TAG_IN_LINE_LISTA_ID = 6;
    protected static final short TAG_IN_START_RUN_ID = 7;
    protected static final short TAG_IN_VAR_FISCALE_RUN_ID = 8;
    protected static final short TAG_IN_VAR_RUN_ID = 9;
    protected static final short TAG_IN_ANAGRAFICA_RUN_ID = 10;
    protected static final short TAG_IN_CONTINUAZIONE_ANAGRAFICA_ID = 11;
    protected static final short TAG_IN_INDIRIZZO_RUN_ID = 12;
    protected static final short TAG_IN_CAP_RUN_ID = 13;
    protected static final short TAG_IN_LOCALITA_RUN_ID = 14;
    protected static final short TAG_IN_PROVINCIA_RUN_ID = 15;
    protected static final short TAG_IN_EMAIL_RUN_ID = 16;
    protected static final short TAG_IN_START_PAGAMENTO_ID = 17;
    protected static final short TAG_IN_PROGRESSIVO_ID = 18;
    protected static final short TAG_IN_IMPORTO_ID = 19;
    protected static final short TAG_IN_SCADENZA_ID = 20;
    protected static final short TAG_IN_IDENTIFICATIVO_DISPOSIZIONE_ID = 21;
    protected static final short TAG_IN_CAUSALE_BOLLETTINO_ID = 22;
    protected static final short TAG_IN_INVIO_PDF_RUN_ID = 23;
    //TODO:verificare se id 23 va bene
    protected static final String TAG_IN_NOME_ATT_MODIFICABILE = "modificabile";
    private static final String L_ELEMENTO = "L'elemento [";
    protected short currentActivity;
    protected StringBuffer currentContent = null;

    public XmlInputHandler() {
        super();
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        currentActivity = getElementID(qName);
//        log.debug("Current activity [" + currentActivity + "] [" + currentContent + "]");
        switch (currentActivity) {
            case TAG_IN_VAR_SIA_ID:
                getNoteCustomMulti().setVARSia(currentContent.toString().trim());
                break;
            case TAG_IN_VAR_SERVIZIO_ID:
                getNoteCustomMulti().setVARServizio(currentContent.toString().trim());
                break;
            case TAG_IN_VAR_SOTTOSERVIZIO_ID:
                getNoteCustomMulti().setVARSottoservizio(currentContent.toString().trim());
                break;
            case TAG_IN_LINE_LISTA_ID:
                getNoteCustomMulti().setLINELista(currentContent.toString().trim());
                break;
            case TAG_IN_VAR_FISCALE_RUN_ID:
                getNoteCustomMulti().setVARFiscaleRUN(currentContent.toString().trim());
                break;
            case TAG_IN_VAR_RUN_ID:
                getNoteCustomMulti().setVARRUN(currentContent.toString().trim());
                break;
            case TAG_IN_ANAGRAFICA_RUN_ID:
                getNoteCustomMulti().setAnagraficaRUN(currentContent.toString().trim());
                break;
            case TAG_IN_CONTINUAZIONE_ANAGRAFICA_ID:
                getNoteCustomMulti().setContinuazioneAnagrafica(currentContent.toString().trim());
                break;
            case TAG_IN_INDIRIZZO_RUN_ID:
                getNoteCustomMulti().setIndirizzoRUN(currentContent.toString().trim());
                break;
            case TAG_IN_CAP_RUN_ID:
                getNoteCustomMulti().setCapRUN(currentContent.toString().trim());
                break;
            case TAG_IN_LOCALITA_RUN_ID:
                getNoteCustomMulti().setLocalitaRUN(currentContent.toString().trim());
                break;
            case TAG_IN_PROVINCIA_RUN_ID:
                getNoteCustomMulti().setProvinciaRUN(currentContent.toString().trim());
                break;
            case TAG_IN_EMAIL_RUN_ID:
                getNoteCustomMulti().setEmailRUN(currentContent.toString().trim());
                break;
            case TAG_IN_INVIO_PDF_RUN_ID:
                getNoteCustomMulti().setInvioPdfRUN(currentContent.toString().trim());
                break;
            case TAG_IN_IMPORTO_ID:
                getDettaglio().setImporto(currentContent.toString().trim());
                break;
            case TAG_IN_SCADENZA_ID:
                getDettaglio().setScadenza(currentContent.toString().trim());
                break;
            case TAG_IN_IDENTIFICATIVO_DISPOSIZIONE_ID:
                getDettaglio().setIdentificativoDisposizione(currentContent.toString().trim());
                break;
            case TAG_IN_CAUSALE_BOLLETTINO_ID:
	        	*/
/* PRO #4853
	        	String value = currentContent.toString().trim(); *//*

                String value = currentContent.toString();
//                log.debug("Causale before replace [" + value + "]");
                getDettaglio().setCausaleBollettino(value.replaceAll("(\n|\r\n)+", " "));
//                log.debug("Causale after replace [" + getDettaglio().getCausaleBollettino() + "]");
                break;
            case TAG_IN_START_PAGAMENTO_ID: // Alcuni controlli addizionali sui dettagli di pagamento
//                log.debug("Controlli addizionali");
                if (getDettaglio().getImporto() == null) {
                    throw new SAXException(L_ELEMENTO + TAG_IN_IMPORTO + "] deve essere presente");
                }
                if (getDettaglio().getCausaleBollettino() != null && getDettaglio().getCausaleBollettino().length() > 10) {
                    throw new SAXException(L_ELEMENTO + TAG_IN_CAUSALE_BOLLETTINO + "] ha lunghezza superiore alla massima consentita di " + 10 + " caratteri");
                }
                break;
            case TAG_IN_ACQUISIZIONE_AVVISO_ID: // Alcuni controlli addizionali sull'intero avviso
//                log.debug("Controlli addizionali globali");
                if (getNoteCustomMulti().getLINELista() == null) {
                    throw new SAXException(L_ELEMENTO + TAG_IN_LINE_LISTA + "] deve essere presente");
                }
                break;
            default:
        }
    }

    protected short getElementID(String element) {
        switch (element) {
            case TAG_IN_ACQUISIZIONE_AVVISO:
                return TAG_IN_ACQUISIZIONE_AVVISO_ID;
            case TAG_IN_LINE_DISPOSIZIONI:
                return TAG_IN_LINE_DISPOSIZIONI_ID;
            case TAG_IN_START_BANCA:
                return TAG_IN_START_BANCA_ID;
            case TAG_IN_VAR_SIA:
                return TAG_IN_VAR_SIA_ID;
            case TAG_IN_VAR_SERVIZIO:
                return TAG_IN_VAR_SERVIZIO_ID;
            case TAG_IN_VAR_SOTTOSERVIZIO:
                return TAG_IN_VAR_SOTTOSERVIZIO_ID;
            case TAG_IN_LINE_LISTA:
                return TAG_IN_LINE_LISTA_ID;
            case TAG_IN_START_RUN:
                return TAG_IN_START_RUN_ID;
            case TAG_IN_VAR_FISCALE_RUN:
                return TAG_IN_VAR_FISCALE_RUN_ID;
            case TAG_IN_VAR_RUN:
                return TAG_IN_VAR_RUN_ID;
            case TAG_IN_ANAGRAFICA_RUN:
                return TAG_IN_ANAGRAFICA_RUN_ID;
            case TAG_IN_CONTINUAZIONE_ANAGRAFICA:
                return TAG_IN_CONTINUAZIONE_ANAGRAFICA_ID;
            case TAG_IN_INDIRIZZO_RUN:
                return TAG_IN_INDIRIZZO_RUN_ID;
            case TAG_IN_CAP_RUN:
                return TAG_IN_CAP_RUN_ID;
            case TAG_IN_LOCALITA_RUN:
                return TAG_IN_LOCALITA_RUN_ID;
            case TAG_IN_PROVINCIA_RUN:
                return TAG_IN_PROVINCIA_RUN_ID;
            case TAG_IN_EMAIL_RUN:
                return TAG_IN_EMAIL_RUN_ID;
            case TAG_IN_INVIO_PDF_RUN:
                return TAG_IN_INVIO_PDF_RUN_ID;
            case TAG_IN_START_PAGAMENTO:
                return TAG_IN_START_PAGAMENTO_ID;
            case TAG_IN_PROGRESSIVO:
                return TAG_IN_PROGRESSIVO_ID;
            case TAG_IN_IMPORTO:
                return TAG_IN_IMPORTO_ID;
            case TAG_IN_SCADENZA:
                return TAG_IN_SCADENZA_ID;
            case TAG_IN_IDENTIFICATIVO_DISPOSIZIONE:
                return TAG_IN_IDENTIFICATIVO_DISPOSIZIONE_ID;
            case TAG_IN_CAUSALE_BOLLETTINO:
                return TAG_IN_CAUSALE_BOLLETTINO_ID;

            default:
                return -1;
        }
    }

    public void characters(char[] ch, int start, int length) {
        currentContent.append(new String(ch, start, length));
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
        currentContent.append(new String(ch, start, length));
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentActivity = getElementID(qName);
        currentContent = new StringBuffer();

        String attribute = attributes.getValue(TAG_IN_NOME_ATT_MODIFICABILE);
        if (!isModificabileAttribute(attribute)) return;
        switch (currentActivity) {
            case TAG_IN_LINE_LISTA_ID:
                getNoteCustomMulti().setLINEListaModificabile(true);
                break;
            case TAG_IN_VAR_FISCALE_RUN_ID:
                getNoteCustomMulti().setVARFiscaleRUNModificabile(true);
                break;
            case TAG_IN_VAR_RUN_ID:
                getNoteCustomMulti().setVARRUNModificabile(true);
                break;
            case TAG_IN_ANAGRAFICA_RUN_ID:
                getNoteCustomMulti().setAnagraficaRUNModificabile(true);
                break;
            case TAG_IN_CONTINUAZIONE_ANAGRAFICA_ID:
                getNoteCustomMulti().setContinuazioneAnagraficaModificabile(true);
                break;
            case TAG_IN_INDIRIZZO_RUN_ID:
                getNoteCustomMulti().setIndirizzoRUNModificabile(true);
                break;
            case TAG_IN_CAP_RUN_ID:
                getNoteCustomMulti().setCapRUNModificabile(true);
                break;
            case TAG_IN_LOCALITA_RUN_ID:
                getNoteCustomMulti().setLocalitaRUNModificabile(true);
                break;
            case TAG_IN_PROVINCIA_RUN_ID:
                getNoteCustomMulti().setProvinciaRUNModificabile(true);
                break;
            case TAG_IN_EMAIL_RUN_ID:
                getNoteCustomMulti().setEmailRUNModificabile(true);
                break;
            case TAG_IN_IMPORTO_ID:
                getDettaglio().setImportoModificabile(true);
                break;
            case TAG_IN_SCADENZA_ID:
                getDettaglio().setScadenzaModificabile(true);
                break;
            case TAG_IN_CAUSALE_BOLLETTINO_ID:
                getDettaglio().setCausaleBollettinoModificabile(true);
                break;
            default:
        }
    }

    private boolean isModificabileAttribute(String attribute) {
        return attribute != null && attribute.toUpperCase().equals("S");
    }

    public abstract NoteCustom getNoteCustomMulti();

    public abstract DetailsF getDettaglio();


}*/
