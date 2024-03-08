package prog2.model;

import java.time.LocalDateTime;
import prog2.vista.ExcepcioReserva;

/**
 * Interfície per definir la forma del Gimnàs
 * @author lauraigual
 */
public interface InGimnas {

    /**
     * Retorna el nom del gimnàs.
     * @return
     */
    public String getNom();

    /**
     * Retorna el número de serveis total del gimnàs.
     * @return
     */
    public int getNumServeis();

    /**
     * Crea un nou objecte de tipus Soci amb la informació necessària rebuda com a paràmetres i l'afegeix a la llista de socis.
     * @param nom_
     * @param dni_
     */
    public void afegirSoci(String nom_, String dni_);

    /**
     * Crea una pista de tenis amb la informació necessària rebuda com a paràmetres i l'afegeix a la llista de serveis.
     * @param tipusSuperficie_
     * @param iluminada_
     * @param tipusTanca_
     * @param tipusXarxa_
     * @param mida_
     * @param nom_
     * @param idServei_
     */

    public void afegirPistaTenis(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusSuperficie_, String tipusXarxa_);

    /**
     * Crea una pista de futbol amb la informació necessària rebuda com a paràmetres i l'afegeix a la llista de serveis.
     * @param tipusPorteries_
     * @param iluminada_
     * @param numPorteries_
     * @param tipusTanca_
     * @param mida_
     * @param nom_
     * @param idServei_
     */
    public void afegirPistaFutbol(String nom_, String idServei_, boolean iluminada_, String tipusTanca_, float mida_, String tipusPorteries_, int numPorteries_);

    /**
     * Crea una sala de fitness amb la informació necessària rebuda com a paràmetres i l'afegeix a la llista de serveis.
     * @param numMaquines_
     * @param monitor_
     * @param nom_
     * @param idServei_
     */
    public void afegirSalaFitness(String nom_, String idServei_, int numMaquines_, boolean monitor_);



    /**
     * Cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i l'afegirà a la llista de reserves.
     * @param idServei_
     * @param dni_
     * @param data_
     * @throws ExcepcioReserva
     */
    public void afegirReserva(String idServei_, String dni_, LocalDateTime data_) throws ExcepcioReserva;



    /**
     * Suma la mida de totes les pistes disponibles al gimnàs i retorna el valor.
     * @return
     */
    public float calculMidaTotalPistes();


    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el nÃºmero de serveis que estan operatius i retornar el valor.
     * @return
     */
    public int calculServeisOperatius();


}
