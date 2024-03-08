/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author crist
 */
public class Soci {
    private String nom;
    private String dni;

    //Constructor
    public Soci(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    // Getters
    public String getNom(){
        return nom;
    }
    public String getdni(){
        return dni;
    }

    // Mètode toString amb la informació del Soci
    @Override
    public String toString() {
        return " Soci " + nom + " amb dni=" + dni;
    }
}
