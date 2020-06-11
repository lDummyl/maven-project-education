package bonus.refactor.funhell;

import bonus.refactor.funhell.readonly.NoteCustom;
import bonus.refactor.funhell.readonly.NoteCustomSimple;
import bonus.refactor.funhell.readonly.DetailsF;
import org.xml.sax.SAXException;

public class XmlSimpleInputHandler extends XmlInputHandler {
    private NoteCustomSimple avviso = new NoteCustomSimple();

    public XmlSimpleInputHandler() {
        super();
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        super.endElement(namespaceURI, localName, qName);

        currentActivity = -1; // So it doesn't overwrite element content with outside values
    }

    public NoteCustom getNoteCustomMulti() {
        return (avviso);
    }

    public DetailsF getDettaglio() {
        return (avviso.getDettaglio());
    }
}
