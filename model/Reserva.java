package prog2.model;

import java.time.LocalDateTime;
public class Reserva {

    private Soci soci;
    private LocalDateTime data_hora;
    private Servei servei;

    //Constructor
    public Reserva(Servei servei, Soci soci,LocalDateTime data_hora) {
        this.soci = soci;
        this.data_hora = data_hora;
        this.servei = servei;
    }

    // Getters
    public Soci getNomSoci() {
        return soci;
    }

    public LocalDateTime getDataHora(){
        return data_hora;
    }

    public Servei getServei(){
        return servei;
    }



}
