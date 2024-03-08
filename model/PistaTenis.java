/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author nacho
 */
public class PistaTenis extends Pista {
    /*Implementar metode CorrecteFuncionament per aconseguir la funcionalitat 7
    definida a la descripcio de la practica a la seccio 1*/
    /*subclase de servei.Els construcotors han de rebre els paremetres en el
    mateix ordre que els reben els metodes afegirPistaTenis,afegirPistaPadel,
    afegirSalafitness de la classe gimnas*/

    private String TipusSuperficie_,TipusXarxa_;

    //constructor
    public PistaTenis(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusSuperficie_, String tipusXarxa_){
        super(nom_,idServei_,tipusTanca_,iluminada_,mida_);
        this.TipusSuperficie_=tipusSuperficie_;
        this.TipusXarxa_=tipusXarxa_;

    }
    //getters i setters
    @Override
    public String getNom(){
        return getNom_();
    }
    @Override
    public void setNom(String nom_)
    {    }
    @Override
    public String getIdServei(){
        return getIdServei_();
    }
    @Override
    public void setIdServei(String id){}

    public String getTipusSuperficie_() {
        return TipusSuperficie_;
    }

    public String getTipusXarxa_() {
        return TipusXarxa_;
    }
    //ens retorna en format String tota la informació de la pista de tenis, aqui fem servir molt els getters
    @Override
    public String toString(){
        return "La pista de tennis té nom "+getNom()+" amb identificador de servei "+getIdServei()+" amb temps de reserva "+getTempsSlotReserva()+" amb tipus de superficie "+getTipusSuperficie_()+" amb xarxa "+getTipusXarxa_()+"\n";
    }
    //El temps de reserva d'una pista de tennis és de 60 minuts
    public long getTempsSlotReserva() {
        return 60;
    }
    @Override
    // Permetrà comprovar el correcte funcionament del servei, depenent de si la xarxa és de tipus sense o no.
    public boolean correcteFuncionament(){
        //Es correcta si té xarxa
        return !"Sense".equals(TipusXarxa_);

    }
}
