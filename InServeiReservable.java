
package prog2.model;

/**
 * Interficie per definir la forma dels serveis reservables
 * @author lauraigual
 */
public interface InServeiReservable {


    public String getNom();

    public void setNom(String nom);

    public String getIdServei();

    public void setIdServei(String id);

    public long getTempsSlotReserva();

    public void setTempsSlotReserva(long tempsSlotReserva);

    @Override
    public String toString();

    // Permetre comprovar el correcte funcionament del servei.
    public boolean correcteFuncionament();

}
