package bonus.refactor.funhell.readonly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NoteCustom {

    private String VARSia = null;
    private String VARServizio = null;
    private String VARSottoservizio = null;
    private String LINELista = null;
    private boolean LINEListaModificabile;

    private String VARFiscaleRUN = null;
    private boolean VARFiscaleRUNModificabile;
    private String VARRUN = null;
    private boolean VARRUNModificabile;
    private String anagraficaRUN = null;
    private boolean anagraficaRUNModificabile;
    private String continuazioneAnagrafica = null;
    private boolean continuazioneAnagraficaModificabile;
    private String indirizzoRUN = null;
    private boolean indirizzoRUNModificabile;
    private String capRUN = null;
    private boolean capRUNModificabile;
    private String localitaRUN = null;
    private boolean localitaRUNModificabile;
    private String provinciaRUN = null;
    private boolean provinciaRUNModificabile;
    private String emailRUN = null;
    private boolean emailRUNModificabile;
    private String invioPdfRUN = null;
    private String valoreVARBarre;
    private int LINEDisposizioni = 0;
    private DetailsF dettagli[] = null;

    public NoteCustom() {
    }

    public NoteCustom(NoteCustom copy) {
        setVARSia(copy.getVARSia());
        setVARServizio(copy.getVARServizio());
        setVARSottoservizio(copy.getVARSottoservizio());
        setLINELista(copy.getLINELista());
        setLINEListaModificabile(copy.isLINEListaModificabile());
        setVARFiscaleRUN(copy.getVARFiscaleRUN());
        setVARFiscaleRUNModificabile(copy.isVARFiscaleRUNModificabile());
        setVARRUN(copy.getVARRUN());
        setVARRUNModificabile(copy.isVARRUNModificabile());
        setAnagraficaRUN(copy.getAnagraficaRUN());
        setAnagraficaRUNModificabile(copy.isAnagraficaRUNModificabile());
        setContinuazioneAnagrafica(copy.getContinuazioneAnagrafica());
        setContinuazioneAnagraficaModificabile(copy.isContinuazioneAnagraficaModificabile());
        setIndirizzoRUN(copy.getIndirizzoRUN());
        setIndirizzoRUNModificabile(copy.isIndirizzoRUNModificabile());
        setCapRUN(copy.getCapRUN());
        setCapRUNModificabile(copy.isCapRUNModificabile());
        setLocalitaRUN(copy.getLocalitaRUN());
        setLocalitaRUNModificabile(copy.isLocalitaRUNModificabile());
        setProvinciaRUN(copy.getProvinciaRUN());
        setProvinciaRUNModificabile(copy.isProvinciaRUNModificabile());
        setEmailRUN(copy.getEmailRUN());
        setEmailRUNModificabile(copy.isEmailRUNModificabile());
        setInvioPdfRUN(copy.getInvioPdfRUN());
        setLINEDisposizioni(copy.getLINEDisposizioni());
        setValoreVARBarre(copy.getValoreVARBarre());
        for (int i = 0; i < getLINEDisposizioni(); ++i)
            setDettaglio(i, copy.getDettaglio(i));
    }
    /**
     * @param LINEDisposizioni The LINEDisposizioni to set.
     */
    public void setLINEDisposizioni(int LINEDisposizioni) {
        if (LINEDisposizioni > 0) {
            this.LINEDisposizioni = LINEDisposizioni;
            this.dettagli = new DetailsF[LINEDisposizioni];
        }
    }

    /**
     * @param i Occurence of dettaglio to allocate.
     */
    public void addDettaglio(int i) {
	    if (i < LINEDisposizioni) {
		    dettagli[i] = new DetailsF();
	    }
    }

    /**
     * @param i Occurence of dettaglio to return.
     */
    public DetailsF getDettaglio(int i) {
        if (i < LINEDisposizioni) {
            return (dettagli[i]);
        }
        return (null);
    }

    /**
     * @param i         Occurence of dettaglio to set.
     * @param dettaglio Dettaglio instance to set.
     */
    public void setDettaglio(int i, DetailsF dettaglio) {
        if (i < LINEDisposizioni) {
            dettagli[i] = dettaglio;
        }
    }


    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("VARSia [").append(getVARSia()).append("] ");
        out.append("VARServizio [").append(getVARServizio()).append("] ");
        out.append("VARSottoservizio [").append(getVARSottoservizio()).append("] ");
        out.append("LINELista [").append(getLINELista()).append("|").append(isLINEListaModificabile()).append("] ");
        out.append("VARFiscaleRUN [").append(getVARFiscaleRUN()).append("|").append(isVARFiscaleRUNModificabile()).append("] ");
        out.append("VARRUN [").append(getVARRUN()).append("|").append(isVARRUNModificabile()).append("] ");
        out.append("anagraficaRUN [").append(getAnagraficaRUN()).append("|").append(isAnagraficaRUNModificabile()).append("] ");
        out.append("continuazioneAnagrafica [").append(getContinuazioneAnagrafica()).append("|").append(isContinuazioneAnagraficaModificabile()).append("] ");
        out.append("indirizzoRUN [").append(getIndirizzoRUN()).append("|").append(isIndirizzoRUNModificabile()).append("] ");
        out.append("capRUN [").append(getCapRUN()).append("|").append(isCapRUNModificabile()).append("] ");
        out.append("localitaRUN [").append(getLocalitaRUN()).append("|").append(isLocalitaRUNModificabile()).append("] ");
        out.append("provinciaRUN [").append(getProvinciaRUN()).append("|").append(isProvinciaRUNModificabile()).append("] ");
        out.append("emailRUN [").append(getEmailRUN()).append("|").append(isEmailRUNModificabile()).append("] ");
        out.append("invioPdfRUN [").append(getInvioPdfRUN()).append("] ");
        out.append("valoreVARBarre [").append(getValoreVARBarre()).append("] ");

        return (out.toString());
    }


}

