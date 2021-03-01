import java.util.*;
import java.lang.*;

/**
 * <h10>City</h10>
 * @author Isac Iulian-George
 * Implementarea clasei City
 */
class City {
    List<Location> locationList;

    /**
     * Constructor
     * @param locations
     */
    City(List<Location> locations){
        locationList = new ArrayList<>();
        locationList = locations;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Location> getLocationList()
    {
        return locationList;
    }
    public void showCosts()
    {
        for(int iteratorList=0;iteratorList<locationList.size();iteratorList++)
        {
            Location temporaryLocation = locationList.get(iteratorList);
            for(Location key: temporaryLocation.getTimesBetweenLocations().keySet())
            {
                System.out.println(temporaryLocation.getName() +  " -> " + key.getName() + " = " + temporaryLocation.getTimeLocation(key));
            }
        }
    }

   public void displayLocations()
   {
       System.out.print(",");
       List<ChurchOptional> listOfChurches = new ArrayList<>();
       for(int iteratorListOfLocations=0;iteratorListOfLocations<locationList.size();iteratorListOfLocations++)
       {
         if(locationList.get(iteratorListOfLocations) instanceof ChurchOptional )
         {
             System.out.print(locationList.get(iteratorListOfLocations).getName()+",");
         }
       }
   }
}
