import java.util.HashMap;
import java.util.Map;

/**
 * <h12> Church </h12>
 * @author  Isac Iulian-George
 * Implementarea clasei Church
 */
class Church extends  Location implements Visitable  {
    String openingHour;
    String closingHour;
    public HashMap<Location,Double> getTimesBetweenLocations()
    {
        return  this.timesBetweenLocations;
    }
    /**
     * Constructor
     * @param name
     * @param address
     * @param description
     * @param openingHour
     * @param closingHour
     */
    Church(String name,String address,String description,String openingHour,String closingHour)
    {
        this.setName(name );
        this.setAdress(address);
        this.setDescription(description);
        this.setOpeningHour(openingHour);
        this.setClosingHour(closingHour);
        this.timesBetweenLocations = new HashMap<>();
    }
    @Override
    public void setOpeningHour(String openingHour) {
         this.openingHour = openingHour;
    }

    @Override
    public void setClosingHour(String closingHour) {
           this.closingHour = closingHour;
    }

    @Override
    public String getOpeningHour() {
        return this.openingHour;
    }

    @Override
    public String getClosingHour() {
        return this.closingHour;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setName(String name) {
       this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setAdress(String address) {
         this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    void setTimeToLocation(Location location, double time) {
          timesBetweenLocations.put(location,time);
    }

    @Override
    double getTimeLocation(Location location) {
        return timesBetweenLocations.get(location);
    }
}
