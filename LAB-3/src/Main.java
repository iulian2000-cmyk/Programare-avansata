import java.util.*;

public class Main {

    public static void main(String[] args) {
	     Location hotel_v1 = new Hotel("v1","Suceava","Ok",1);
	     Location museum_v2 = new Museum("v2","Iasi","Bun",12,"8:00","19:00");
	     Location museum_v3 = new Museum("v3","Iasi","Ok",13,"10:00","20:00");
	     Location church_v4 = new Church("v4","Iasi","Ok","8:00","12:00");
	     Location church_v5 = new Church("v5","Iasi","Ok","7:00","11:00");
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
	     city.showCosts();
    }
}
