import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;
/**
 * <h5> MuseumOptional</h5>
 * @author : Isac Iulian-George
 * Implementarea clasei MuseumOptional
 */

class MuseumOptional extends Location implements VisitableOptional,Payable{
    double priceTicket;
    LocalTime openingHour;
    LocalTime closingHour;

    static Duration getDuration(){
        return Duration.between(VisitableOptional.openingHour,VisitableOptional.closingHour);
    }
    MuseumOptional(String name,String adress,String description,double price,LocalTime time1,LocalTime time2) {

        this.setName(name);
        this.setAdress(address);
        this.setDescription(description);
        this.setPriceTicket(price);
        this.setOpeningHour(time1);
        this.setClosingHour(time2);
        this.timesBetweenLocations = new HashMap<>();
    }

    @Override
    public Map<Location, Double> getTimesBetweenLocations() {
        return this.timesBetweenLocations;
    }

    @Override
    public void setDescription(String description) {
          this.description=description;
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

    @Override
    public void setPriceTicket(double price) {
          this.priceTicket = price;
    }

    @Override
    public double getPriceTicket() {
        return this.priceTicket;
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
        return this.openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return this.closingHour;
    }
}
