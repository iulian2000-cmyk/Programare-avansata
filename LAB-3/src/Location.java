/**
 * <h7> Location </h7>
 * @author : Isac Iulian-George
 * Implementarea clasei Location
 */
import java.util.*;
abstract class Location {
    String name;
    String address;
    String description;
    HashMap <Location,Double> timesBetweenLocations;

    /**
     * Getter pentru map .
     * @return Map<Location,Double>
     */
    abstract public  Map<Location,Double> getTimesBetweenLocations();
    /**
     * Setter pentru  descriere
     * @param description
     * @return void
     */

    abstract public void setDescription(String description);

    /**
     * Getter pentru descriere
     * @return String
     */
    abstract public String getDescription();

    /**
     * Setter pentru numele locatiei .
     * @param name
     * @return void
     */
    abstract public void setName(String name);

    /**
     * Getter pentru numele locatiei .
     * @return String
     */
    abstract  public String getName();

    /**
     * Setter pentru adresa .
     * @param address
     * @return void
     */
    abstract public void setAdress(String address);

    /**
     * Getter pentru adresa .
     * @return String
     */
    abstract public String getAddress();

    /**
     * Setter pentru timpul de mers dintre locatia curenta si alta locatie .
     * @param location
     * @param time
     */
    abstract void setTimeToLocation(Location location,double time);
    /**
     * Getter pentru timpul de mers dintre locatia curenta si alta locatie
     * @return double
     */
    abstract double getTimeLocation(Location location);

}
