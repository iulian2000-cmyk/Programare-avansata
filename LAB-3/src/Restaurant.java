import java.util.HashMap;
import java.util.Map;

/**
 * <h3> Restaurant</h3>
 * @author  : Isac Iulian-George
 * Implementarea clasei Restaurant
 */
class Restaurant  extends  Location implements Classifiable {
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
    Restaurant(String name,String address,String description,int rank)
    {
      this.setName(name);
      this.setAdress(address);
      this.setDescription(description);
      this.setRank(rank);
      this.timesBetweenLocations = new HashMap<>();
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
    void setTimeToLocation(Location location, double time) {
          timesBetweenLocations.put(location,time);
    }

    @Override
    double getTimeLocation(Location location) {
        return  timesBetweenLocations.get(location);
    }
    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return this.rank;
    }
}
