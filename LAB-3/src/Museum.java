import java.util.HashMap;
import java.util.Map;

/**
 * <h6> Museum </h6>
 * @author : Isac Iulian-George
 * Implementarea clasei "Museum"
 */
class Museum extends Location implements Payable,Visitable {

    private double priceTicket;
    private String openingHour;
    private String closingHour;

    /**
     * Constructor
     * @param name
     * @param address
     * @param description
     * @param priceTicket
     * @param openingHour
     * @param closingHour
     */
    Museum(String name,String address,String description,double priceTicket,String openingHour,String closingHour)
    {
        this.setName(name);
        this.setAdress(address);
        this.setDescription(description);
        this.setPriceTicket(priceTicket);
        this.setOpeningHour(openingHour);
        this.setClosingHour(closingHour);
        this.timesBetweenLocations = new HashMap<>();
    }

    @Override
    public Map<Location, Double> getTimesBetweenLocations() {
        return this.timesBetweenLocations;
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
        return  this.address;
    }

    @Override
    public void setPriceTicket(double price) {
          this.priceTicket =price;
    }

    @Override
    public double getPriceTicket() {
        return this.priceTicket;
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
    public void setTimeToLocation(Location location,double time)
    {
        timesBetweenLocations.put(location,time);
    }
    public double getTimeLocation(Location location)
    {
        return timesBetweenLocations.get(location);
    }

    public Map<Location,Double> getTimesBeweenLocations()
    {
        return  this.timesBetweenLocations;
    }
}
