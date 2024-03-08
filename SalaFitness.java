package prog2.model;

public class SalaFitness extends Servei {
    private int n_maquines;
    private boolean monitor;
    private String idServei_,nom_;
    //constructor
    public SalaFitness(String nom_,String idServei_,int numMaquines_, boolean monitor_){
        super(nom_,idServei_);
        this.monitor = monitor_;
        this.n_maquines = numMaquines_;
    }
    //getters i setters
    @Override
    public String getNom(){
        return nom_;
    }
    @Override
    public String getIdServei(){
        return idServei_;
    }
    public void setNom(String nom) {
        this.nom_ = nom;
    }
    @Override
    public void setIdServei(String id) {
        this.idServei_ = id;
    }
    //El temps de reserva d'una pista de tennis és de 60 minuts
    public long getTempsSlotReserva() {
        return 30;
    }

    public int getN_maquines() {
        return n_maquines;
    }
    public boolean getmonitor(){
        return monitor;
    }
    //Ens retorna tota la informació de la sala de fitness dient si té monitor o no
    public String toString() {
        if(getmonitor()) {
            return "La pista de tennis té nom " + getNom() + " amb identificador de servei " + getIdServei() + " amb temps de reserva " + getTempsSlotReserva() + " amb " + getN_maquines() + " maquines i té monitor\n";
        }
        else {
            return "La pista de tennis té nom " + getNom() + " amb identificador de servei " + getIdServei() + " amb temps de reserva " + getTempsSlotReserva() + " amb " + getN_maquines() + " maquines i no té monitor \n";
        }
    }
    @Override
    //fem un Override de correcte funcionament per definir-ho en aquesta classe de manerque si la sala de fitness té més d'una màquina doni que si que funciona de forma correcte
    public boolean correcteFuncionament(){
        //Té al menys una màquina disponible
        return n_maquines>=1;
    }
}
