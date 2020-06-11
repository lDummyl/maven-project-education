package bonus.refactor.funhell;

import bonus.refactor.funhell.readonly.NoteCustom;
import bonus.refactor.funhell.readonly.NoteCustomMulti;
import bonus.refactor.funhell.readonly.DetailsF;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

//@Slf4j
public class XmlMultiInputHandler extends XmlInputHandler {
    private NoteCustomMulti noteCustomMulti = new NoteCustomMulti();
    private int currentDisposizione = -1;

    public XmlMultiInputHandler() {
        super();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);


            if(currentActivity == TAG_IN_START_PAGAMENTO_ID) {
                currentDisposizione += 1;
                if (currentDisposizione >= noteCustomMulti.getLINEDisposizioni()) {
                    throw new SAXException("LINE di elementi " + TAG_IN_START_PAGAMENTO + " superiore al " + TAG_IN_LINE_DISPOSIZIONI + " indicato");
                }
                noteCustomMulti.addDettaglio(currentDisposizione);
            }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        super.endElement(namespaceURI, localName, qName);

        switch (currentActivity) {
            case TAG_IN_LINE_DISPOSIZIONI_ID:
                noteCustomMulti.setLINEDisposizioni(Integer.parseInt(currentContent.toString().trim()));
                break;
            case TAG_IN_PROGRESSIVO_ID:
                int progressivo = Integer.parseInt(currentContent.toString().trim());
                if (progressivo != (currentDisposizione + 1)) {
                    throw new SAXException("Progressivo presente [" + progressivo + "] non corrisponde a quello atteso [" + (currentDisposizione + 1) + "]");
                }
                break;
            case TAG_IN_ACQUISIZIONE_AVVISO_ID: // Alcuni controlli addizionali sull'intero avviso multi
//                log.debug("Controlli addizionali globali per avviso multi");
                currentDisposizione += 1;
                if (currentDisposizione < noteCustomMulti.getLINEDisposizioni()) {
                    throw new SAXException("LINE di elementi " + TAG_IN_START_PAGAMENTO + " inferiore al " + TAG_IN_LINE_DISPOSIZIONI + " indicato");
                }
                break;
            default:
        }
        currentActivity = -1; // So it doesn't overwrite element content with outside values
    }

    public NoteCustom getNoteCustomMulti() {
        return (noteCustomMulti);
    }

    public DetailsF getDettaglio() {
        return (noteCustomMulti.getDettaglio(currentDisposizione));
    }
}
