import javax.swing.plaf.DimensionUIResource;
import java.util.HashMap;
import java.util.Map;
import java.time.*;

/**
 * <h11> ChurchOptional </h11>
 * @author : Isac Iulian-George
 * Implementarea clasei ChurchOptional
 */
class ChurchOptional extends  Location implements VisitableOptional
{
    private static LocalTime openingHour;
    private static LocalTime closingHour;
    static Duration getDuration(){
        return Duration.between(openingHour,closingHour);
    }
    @Override
    public void setOpeningHour(LocalTime time) {
         this.openingHour = time;
    }
    @Override
    public void setClosingHour(LocalTime time) {
        this.closingHour = time;
    }
    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return this.closingHour;
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
        this.setOpeningHourDefault(openingHour);
        this.setClosingHourDefault(closingHour);
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