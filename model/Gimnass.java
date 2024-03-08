/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author crist
 */
public class Gimnas implements InGimnas {
    private String nom;
    ArrayList<Servei> llistaServeis = new ArrayList<Servei>();
    ArrayList<Soci> llistaSocis = new ArrayList<Soci>();
    LlistaReserves llistaReserves;

    //Constructor
    public Gimnas(String nom) {
        this.nom=nom;
        this.llistaReserves = new LlistaReserves();
    }

    // Getters
    @Override
    public int getNumServeis(){
        return llistaServeis.size();
    }
    /**
     * Retorna el nom del gimnàs.
     * @return
     */
    @Override
    public String getNom(){
        return nom;
    }
    /**
     * Crea un nou objecte de tipus Soci amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de socis.
     * @param nom_
     * @param dni_
     */
    @Override
    public void afegirSoci(String nom_, String dni_){
        Soci soci= new Soci(nom_, dni_);
        llistaSocis.add(soci);

    }

    /**
     * Crea una pista de tenis amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param tipusSuperficie_
     * @param iluminada_
     * @param tipusTanca_
     * @param tipusXarxa_
     * @param mida_
     * @param nom_
     * @param idServei_
     */

    @Override
    public void afegirPistaTenis(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusSuperficie_, String tipusXarxa_){
        PistaTenis pista= new PistaTenis(nom_,idServei_,iluminada_,tipusTanca_,mida_,tipusSuperficie_,tipusXarxa_);
        llistaServeis.add(pista);

    }

    /**
     * Crea una pista de futbol amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param tipusPorteries_
     * @param iluminada_
     * @param numPorteries_
     * @param tipusTanca_
     * @param mida_
     * @param nom_
     * @param idServei_
     */
    @Override
    public void afegirPistaFutbol(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusPorteries_, int numPorteries_){
        PistaFutbol pista = new PistaFutbol(nom_,idServei_,iluminada_,tipusTanca_,mida_,tipusPorteries_,numPorteries_);
        llistaServeis.add(pista);

    }

    /**
     * Crea una sala de fitness amb la informació necessària rebuda com a paràmetres i l’afegeix a la llista de serveis.
     * @param numMaquines_
     * @param monitor_
     * @param nom_
     * @param idServei_
     */
    @Override
    public void afegirSalaFitness(String nom_, String idServei_, int numMaquines_, boolean monitor_){
        SalaFitness sala = new SalaFitness(nom_,idServei_,numMaquines_,monitor_);
        llistaServeis.add(sala);
    }



    /**
     * Cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a
     * paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la
     * afegirà a la llista de reserves.
     * @param idServei_
     * @param dni_
     * @param data_
     * @throws ExcepcioReserva
     */

    public void afegirReserva(String idServei_, String dni_, LocalDateTime data_) throws ExcepcioReserva {

        //Busquem el servei i el soci
        Servei servei = buscarServei(idServei_);
        Soci soci = buscarSoci(dni_);

        // Invoquem el mètode afegirReserva si existeix el servei i el soci, en cas contrari s'envia una excepció
        if (servei != null && soci != null){
            llistaReserves.afegirReserva(servei, soci, data_);

        }else{
            throw new ExcepcioReserva("Error a l'hora de realitzar la reserva, el soci o servei no existeixen.");
        }
    }



    /**
     * Suma la mida de totes les pistes disponibles al gimnàs i retorna el valor.
     * @return
     */
    @Override
    public float calculMidaTotalPistes(){
        float mida=0.0f;
        Iterator<Servei> itrserveis = llistaServeis.iterator();
        while(itrserveis.hasNext()){
            Servei servicio=itrserveis.next();
            if(servicio instanceof Pista){
                mida=mida + ((Pista) servicio).getmida_();
            }
        }
        return mida;
    }


    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius i retornar el valor.
     * @return
     */
    @Override
    public int calculServeisOperatius(){
        int n_operatius=0;
        Iterator<Servei> itrserveis = llistaServeis.iterator();
        while(itrserveis.hasNext()){
            Servei servicio=itrserveis.next();
            if(servicio.correcteFuncionament()){
                n_operatius=n_operatius+1;
            }
        }
        return n_operatius;
    }


    //Mètode que busca el Servei a partir de l'identificador
    public Servei buscarServei(String id) {
        Iterator<Servei> itrserveis = llistaServeis.iterator();

        while (itrserveis.hasNext()) {
            Servei servei = itrserveis.next();
            if (servei.getIdServei_().equals(id)) {
                return servei; // Retorna el servei si el troba
            }
        }
        return null; // Retorna null en cas contrari

    }

    // Mètode que busca el Soci a partir del dni
    public Soci buscarSoci(String dni) {
        Iterator<Soci> itrsocis = llistaSocis.iterator();

        while (itrsocis.hasNext()) {
            Soci soci = itrsocis.next();
            if (soci.getdni().equals(dni)) {
                return soci; // Retorna el soci si el troba
            }
        }
        return null; // Retorna null en cas contrari
    }


}
