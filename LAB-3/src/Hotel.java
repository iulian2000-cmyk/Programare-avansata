import java.util.HashMap;
import java.util.Map;

/**
 * <h8> Hotel</h8>
 * @author  Isac Iulian-George
 * Implementarea clasei Hotel
 */
class Hotel extends  Location implements Classifiable {
    private int rank;

    public Map<Location,Double> getTimesBetweenLocations()
    {
        return  this.timesBetweenLocations;
    }
    /**
     * Constructor
     * @param name
     * @param address
     * @param description
     * @param rank
     */
    Hotel(String name,String address,String description,int rank)
    {
        this.setName(name);
        this.setAdress(address);
        this.setAdress(description);
        this.setRank(rank);
        this.timesBetweenLocations = new HashMap<>();
    }
    @Override
    public void setRank(int rank) {
       this.rank = rank;
    }

    @Override
    public int getRank() {
        return this.rank;
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
    double getTimeLocation(Location location) {
        return timesBetweenLocations.get(location);
    }
}
