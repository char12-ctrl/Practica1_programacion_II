/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;


/**
 *
 * @author nacho
 */
public abstract class Servei implements InServeiReservable {
    private String idServei_;
    private String nom_;
    private long temps_;
    
    //constructor
    public Servei(String nom_, String idServei_) {
        this.idServei_ = idServei_;
        this.nom_ = nom_;
    }
    
    //Getters i setters
    public String getNom_() {
        return nom_;
    }

    public void setNom(String nom) {
    }

    public String getIdServei_() {
        return idServei_;
    }

    public void setIdServei(String id) {
    }

    public long getTempsSlotReserva() {
        return temps_;
    }

    public void setTempsSlotReserva(long tempsSlotReserva) {
        this.temps_=tempsSlotReserva;
    }
    
    //ToString no fa res ja que fem un Override a les classes on esta implementat
    public String toString() {
        return null;
    }
    //orrecteFuncionament() no fa res ja que fem un Override a les classes on està implementat
    public boolean correcteFuncionament() {
        return false;
    }

}
