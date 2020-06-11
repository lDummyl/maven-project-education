package bonus.refactor.funhell.readonly;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.function.BiConsumer;

public class NoteCustomSimple extends NoteCustom implements Serializable {
    private static final long serialVersionUID = 1L;

    public NoteCustomSimple() {
        super();
        setLINEDisposizioni(1);
        addDettaglio(0);
    }

    public NoteCustomSimple(NoteCustom copy, DetailsF copyDetail) {
        super(copy);
        setLINEDisposizioni(1);
        setDettaglio(0, copyDetail);
    }

    public DetailsF getDettaglio() {
        return getDettaglio(0);
    }

    public void setDettaglio(DetailsF dettaglio) {
        setDettaglio(0, dettaglio);
    }

    /**
     * @return Returns the causaleBollettino.
     */
    public String getCausaleBollettino() {
        return getDettaglio().getCausaleBollettino();
    }

    /**
     * @param causaleBollettino The causaleBollettino to set.
     */
    public void setCausaleBollettino(String causaleBollettino) {
        getDettaglio().setCausaleBollettino(causaleBollettino);
    }

    /**
     * @return Returns the causaleBollettinoModificabile.
     */
    public boolean isCausaleBollettinoModificabile() {
        return getDettaglio().isCausaleBollettinoModificabile();
    }

    /**
     * @param causaleBollettinoModificabile The causaleBollettinoModificabile to set.
     */
    public void setCausaleBollettinoModificabile(
            boolean causaleBollettinoModificabile) {
        getDettaglio().setCausaleBollettinoModificabile(causaleBollettinoModificabile);
    }

    /**
     * @return Returns the identificativoDisposizione.
     */
    public String getIdentificativoDisposizione() {
        return getDettaglio().getIdentificativoDisposizione();
    }

    /**
     * @param identificativoDisposizione The identificativoDisposizione to set.
     */
    public void setIdentificativoDisposizione(String identificativoMisposizione) {
        getDettaglio().setIdentificativoDisposizione(identificativoMisposizione);
    }

    /**
     * @return Returns the importo.
     */
    public String getImporto() {
        return getDettaglio().getImporto();
    }

    /**
     * @param importo The importo to set.
     */
    public void setImporto(String importo) {
        getDettaglio().setImporto(importo);
    }

    /**
     * @return Returns the importoModificabile.
     */
    public boolean isImportoModificabile() {
        return getDettaglio().isImportoModificabile();
    }

    /**
     * @param importoModificabile The importoModificabile to set.
     */
    public void setImportoModificabile(boolean importoModificabile) {
        getDettaglio().setImportoModificabile(importoModificabile);
    }

    /**
     * @return Returns the scadenza.
     */
    public String getScadenza() {
        return getDettaglio().getScadenza();
    }

    /**
     * @param scadenza The scadenza to set.
     */
    public void setScadenza(String scadenza) {
        getDettaglio().setScadenza(scadenza);
    }

    /**
     * @return Returns the scadenzaModificabile.
     */
    public boolean isScadenzaModificabile() {
        return getDettaglio().isScadenzaModificabile();
    }

    /**
     * @param scadenzaModificabile The scadenzaModificabile to set.
     */
    public void setScadenzaModificabile(boolean scadenzaModificabile) {
        getDettaglio().setScadenzaModificabile(scadenzaModificabile);
    }

    /*
     * Serializer
     */
    public void serialize(DataOutputStream out) throws IOException {
        out.writeLong(serialVersionUID); // Just to check that same implementation is used

        // VAR sia
        writeToOut(getVARSia(), out);
        // VAR servizio
        writeToOut(getVARServizio(), out);
        // VAR sottoservizio
        writeToOut(getVARSottoservizio(), out);
        // LINE lista
        writeToOut(getLINELista(), out);
        out.writeBoolean(isLINEListaModificabile());
        // VAR Fiscale RUN
        if (getVARFiscaleRUN() == null) {
            out.writeShort(-1);
        } else {
            out.writeUTF(getVARFiscaleRUN().toUpperCase());
        }
        out.writeBoolean(isVARFiscaleRUNModificabile());
        // VAR RUN
        if (getVARRUN() == null) {
            out.writeShort(-1);
        } else {
            out.writeUTF(getVARRUN().toUpperCase());
        }
        out.writeBoolean(isVARRUNModificabile());
        // Anagrafica RUN
        if (getAnagraficaRUN() == null) {
            out.writeShort(-1);
        } else {
            out.writeUTF(getAnagraficaRUN().toUpperCase());
        }
        out.writeBoolean(isAnagraficaRUNModificabile());
        // Continuazione Anagrafica RUN
        writeToOut(getContinuazioneAnagrafica(), out);
        out.writeBoolean(isContinuazioneAnagraficaModificabile());
        // Indirizzo RUN
        writeToOut(getIndirizzoRUN(), out);
        out.writeBoolean(isIndirizzoRUNModificabile());
        // Cap RUN
        writeToOut(getCapRUN(), out);
        out.writeBoolean(isCapRUNModificabile());
        // Localita' RUN
        writeToOut(getLocalitaRUN(), out);
        out.writeBoolean(isLocalitaRUNModificabile());
        // Provincia RUN
        writeToOut(getProvinciaRUN(), out);
        out.writeBoolean(isProvinciaRUNModificabile());
        // Email RUN
        writeToOut(getEmailRUN(), out);
        out.writeBoolean(isEmailRUNModificabile());
        // Importo
        writeToOut(getImporto(), out);
        out.writeBoolean(isImportoModificabile());
        // Scadenza
        writeToOut(getScadenza(), out);
        out.writeBoolean(isScadenzaModificabile());
        // Identificativo Disposizione
        writeToOut(getIdentificativoDisposizione(), out);
        // Causale Bollettino
        writeToOut(getCausaleBollettino(), out);
        out.writeBoolean(isCausaleBollettinoModificabile());
    }

    private void writeToOut(String value, DataOutputStream out) throws IOException {
        if (value == null) {
            out.writeShort(-1);
        } else {
            out.writeUTF(value);
        }
    }

    private void processData(DataInputStream in, BiConsumer<NoteCustomSimple, String> cons)  throws IOException {
        in.mark(Short.SIZE);
        if (in.readShort() >= 0) {
            in.reset();
            cons.accept(this, in.readUTF());
        }
    }

    /*
     * Deserializer
     */
    public void deserialize(DataInputStream in) throws IOException {
        long classVersion = in.readLong();
        if (classVersion != serialVersionUID) {
            throw new ClassCastException("Trying to deserialize instance of version [" + classVersion + "] for class [" + this.getClass().getName() + "]");
        }

        // VAR sia
        processData(in, NoteCustomSimple::setVARSia);

        // VAR servizio
        processData(in, NoteCustomSimple::setVARServizio);

        // VAR sottoservizio
        processData(in, NoteCustomSimple::setVARSottoservizio);

        // LINE lista
        processData(in, NoteCustomSimple::setLINELista);
        setLINEListaModificabile(in.readBoolean());

        // VAR Fiscale RUN
        processData(in, NoteCustomSimple::setVARFiscaleRUN);
        setVARFiscaleRUNModificabile(in.readBoolean());

        // VAR RUN
        processData(in, NoteCustomSimple::setVARRUN);
        setVARRUNModificabile(in.readBoolean());

        // Anagrafica RUN
        processData(in, NoteCustomSimple::setAnagraficaRUN);
        setAnagraficaRUNModificabile(in.readBoolean());

        // Continuazione Anagrafica RUN
        processData(in, NoteCustomSimple::setContinuazioneAnagrafica);
        setContinuazioneAnagraficaModificabile(in.readBoolean());

        // Indirizzo RUN
        processData(in, NoteCustomSimple::setIndirizzoRUN);
        setIndirizzoRUNModificabile(in.readBoolean());

        // Cap RUN
        processData(in, NoteCustomSimple::setCapRUN);
        setCapRUNModificabile(in.readBoolean());

        // Localita' RUN
        processData(in, NoteCustomSimple::setLocalitaRUN);
        setLocalitaRUNModificabile(in.readBoolean());

        // Provincia RUN
        processData(in, NoteCustomSimple::setProvinciaRUN);
        setProvinciaRUNModificabile(in.readBoolean());

        // Email RUN
        processData(in, NoteCustomSimple::setEmailRUN);
        setEmailRUNModificabile(in.readBoolean());

        // Importo
        processData(in, NoteCustomSimple::setImporto);
        setImportoModificabile(in.readBoolean());

        // Scadenza
        processData(in, NoteCustomSimple::setScadenza);
        setScadenzaModificabile(in.readBoolean());

        // Identificativo Disposizione
        processData(in, NoteCustomSimple::setIdentificativoDisposizione);

        // Causale Bollettino
        processData(in, NoteCustomSimple::setCausaleBollettino);
        setCausaleBollettinoModificabile(in.readBoolean());
    }
}
