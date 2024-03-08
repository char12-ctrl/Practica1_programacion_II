package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{
    private ArrayList<Reserva> llistaReserves;

    //Constructor
    public LlistaReserves(){
        this.llistaReserves = new ArrayList<>();
    }

    public ArrayList<Reserva> getLlistaReserves(){
        return llistaReserves;
    }

    //Mètode que crea i afegeix una nova reserva a la llista de Reserves.
    @Override
    public void afegirReserva(Servei servei, Soci soci, LocalDateTime data) throws ExcepcioReserva  {
    //Comprovar que el servei està disponible
        if (serveiDisponible(servei, data)) {

            //Crea una nova reserva
            Reserva novaReserva = new Reserva(servei, soci, data);

            //Afegir a la llista de reserves
            llistaReserves.add(novaReserva);

        }else{
            //Excepció perquè el servei no està disponible
            throw new ExcepcioReserva("El servei amb identificador "+servei.getIdServei_()+ " no està disponible en la data demanada "+ data +" pel soci "+ soci.getNom() +" amb DNI: "
            + soci.getdni());
        }

    }

    // Mètode de suport que indica si el servei a una data i hora concret està disponible
    public boolean serveiDisponible(Servei servei, LocalDateTime data){
        // Si no hi ha reserves el servei està disponible
        if (llistaReserves.isEmpty()) {
            return true;
        }

        //Mirem per cada reserva si hi ha cap servei que coincideixi en les dates i returnem false
        for (Reserva reserva : llistaReserves){

            // Mirem si els identificadors del servei de la reserva i del servei que volem reservar coincideixen
            if (((reserva.getServei()).getIdServei_()).equals(servei.getIdServei_())) {

                // calculem la data final segons el temps del servei
                long temps = servei.getTempsSlotReserva();
                LocalDateTime dataFinal = data.plusHours(temps);

                //Comprovem si es solapa amb la reserva
                if (reserva.getDataHora().isBefore(data) && data.isBefore(reserva.getDataHora().plusHours(temps))) {
                    return false;
                }
                if (reserva.getDataHora().isBefore(dataFinal) && dataFinal.isBefore(reserva.getDataHora().plusHours(temps))) {
                    return false;
                }
            }
        }
        // en cas contrari el servei està disponible
        return true;
    }


}
