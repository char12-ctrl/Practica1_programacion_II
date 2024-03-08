package prog2.model;

public abstract class Pista extends Servei{
    /*subclase de servei.Els construcotors han de rebre els paremetres en el
    mateix ordre que els reben els metodes afegirPistaTenis,afegirPistaPadel,afegirSalafitness de la classe gimnas*/
    private float mida_;
    private String nom_,idServei_;
    public String TipusTanca_;
    public boolean iluminada_;
    //constructor
    public Pista(String nom_, String idServei_,String TipusTanca_,boolean iluminada_,float mida_){
        super(nom_,idServei_);
        this.mida_=mida_;
        this.TipusTanca_=TipusTanca_;
        this.iluminada_=iluminada_;
    }

    //getters
    public String getTipusTanca_(){
        return TipusTanca_;
    }
    public float getmida_(){
        return mida_;
    }
    public boolean getiluminada_() {
        return iluminada_;
    }
}
