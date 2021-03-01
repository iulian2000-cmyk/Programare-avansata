import javax.swing.plaf.DimensionUIResource;
import java.util.HashMap;
import java.util.Map;
import java.time.*;

/**
 * <h11> ChurchOptional </h11>
 * @author : Isac Iulian-George
 * Implementarea clasei ChurchOptional
 */
class ChurchOptional extends  Location implements VisitableOptional  {
    static LocalTime openingHour;
    static LocalTime closingHour;

    static Duration getDuration(){
        return Duration.between(openingHour,closingHour);
    }

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
    ChurchOptional(String name,String address,String description,LocalTime openingHour,LocalTime closingHour)
    {
        this.setName(name );
        this.setAdress(address);
        this.setDescription(description);
        this.setOpeningHour(openingHour);
        this.setClosingHour(closingHour);
        this.timesBetweenLocations = new HashMap<>();
        this.showProgram();
        System.out.println("This location " + this.getName() + " is opened for " + this.getDuration());
    }
    @Override
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    @Override
    public LocalTime getOpeningHour() {
        return this.openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
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