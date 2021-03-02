
import java.time.LocalTime;
import java.util.*;

public class Optional{
    public static void main (String []args)
    {
        Location hotel_v1 = new Hotel("v1","Suceava","Ok",1);
        Location museum_v2 = new MuseumOptional("v2", "Iasi", "Bun", 12, LocalTime.of(8, 0), LocalTime.of(12, 0));
        Location museum_v3 = new MuseumOptional("v3","Iasi","Ok",13,LocalTime.of(12,0),LocalTime.of(18,0));
        Location church_v4 = new ChurchOptional("v4","Iasi","Ok",LocalTime.of(10,0),LocalTime.of(12,0));
        Location church_v5 = new ChurchOptional("v5","Iasi","Ok",LocalTime.of(9,12),LocalTime.of(19,0));
        Location restaurant_v6 = new Restaurant("v6","Iasi","Foarte bun",1);

        hotel_v1.setTimeToLocation(museum_v2,10);
        hotel_v1.setTimeToLocation(museum_v3,50);

        museum_v2.setTimeToLocation(museum_v3,20);
        museum_v2.setTimeToLocation(church_v4,20);
        museum_v2.setTimeToLocation(church_v5,10);

        museum_v3.setTimeToLocation(church_v4,20);
        church_v4.setTimeToLocation(church_v5,30);
        church_v4.setTimeToLocation(restaurant_v6,10);
        church_v5.setTimeToLocation(restaurant_v6,20);

        List <Location> locations = new ArrayList<>();
        locations.add(hotel_v1);
        locations.add(museum_v2);
        locations.add(museum_v3);
        locations.add(church_v4);
        locations.add(church_v5);
        locations.add(restaurant_v6);

        City city = new City(locations);
        Queue<Location> order = new LinkedList<>();

        order.add(museum_v2);
        order.add(hotel_v1);
        order.add(museum_v3);
        order.add(church_v4);
        order.add(church_v5);
        order.add(restaurant_v6);

        TravelPlan travelPlan = new TravelPlan(city,order);
        System.out.println("\n The shortest path for all the locations to all other locations\n");
        for(int iteratorListLocations=0;iteratorListLocations<order.size();iteratorListLocations++)
        {
            travelPlan.ShowAllPaths(travelPlan.getAdjacencyMatrixOfLocations(),iteratorListLocations);
            System.out.println();
        }
        System.out.println("Locations that are visitable but not payable");
        city.displayLocations();
    }
}