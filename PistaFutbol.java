package prog2.model;

/**
 *
 * @author nacho
 */
public class PistaFutbol extends Pista {
    /*Implementar metode CorrecteFuncionament per aconseguir la funcionalitat 7
    definida a la descripcio de la practica a la seccio 1*/
    /*subclase de servei.Els construcotors han de rebre els paremetres en el
    mateix ordre que els reben els metodes afegirPistaTenis,afegirPistaPadel,
    afegirSalafitness de la classe gimnas*/
    private String TipusPorteries_,mida_;
    private int numPorteries_;
    //El constructor es defineix i li passem per parametres els atributs
    public PistaFutbol(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusPorteries_, int numPorteries_){
        super(nom_,idServei_,tipusTanca_,iluminada_,mida_);
        this.TipusPorteries_=tipusPorteries_;
        this.numPorteries_=numPorteries_;
    }
    //getters i setters
   public String getNom(){
        return getNom_();
   }

    public void setNom(String nom) {
    }

    public String getTipusPorteries_() {
        return TipusPorteries_;
    }

    public int getNumPorteries_() {
        return numPorteries_;
    }

    public String getIdServei() {
        return getIdServei_();
    }

    public void setIdServei(String id) {
    }
    //El temps de reserva d'una pista de futbol es de 90 minuts
    public long getTempsSlotReserva() {
        return 90;
    }
    // ens retorna en format string tota la informació de la pista de futbol
    public String toString() {
        return "La pista de futbol té nom "+getNom()+" amb identificador de servei "+getIdServei()+" i temps de reserva "+getTempsSlotReserva()+" amb tipus de porteries "+getTipusPorteries_()+" de quantitat "+getNumPorteries_()+"\n";

    }
    public boolean correcteFuncionament(){
        //Té un correcte funcionament si té un número de porteries disponibles major estricte que 2
        return numPorteries_>2;
    }
}
