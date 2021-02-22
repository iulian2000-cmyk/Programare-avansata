/**
    *  @author : Isac Iulian-George
    *  @version 1.0
    *  @since   2021-02-21
 */
import java.util.*;

public class Optional {
    public static void main(String[] args) {

          /** Crearea obiectelor S1,S2 si S3 si S4 ( ultimul fiind folosit pentru a testa egalitatea dintre obiecte ) */
          SourceOptional S1 = new Factory("S1","X",10);
          SourceOptional S2 = new Warehouse("S2","Y",35);
          SourceOptional S3 = new Warehouse("S3","Z",25);
          SourceOptional S4 = new Warehouse("S3","Z",25);
          /** Crearea obiectelor D1,D2 si D3 */

         DestinationOptional D1 = new DestinationOptional("D1","T",20);
         DestinationOptional D2 = new DestinationOptional("D2","P",25);
         DestinationOptional D3 = new DestinationOptional( "D3","K",25);

         /** Testarea metodei equals(); */
        if(S3.equals(S4))
        {
            System.out.println("S3 and S4 are the same object .");
        }

        /** Crearea vectorilor cu surse , respectiv de destinatari .*/

        Vector <SourceOptional> sources = new Vector<SourceOptional>();
        sources.add(S1);
        sources.add(S2);
        sources.add(S3);

        Vector<DestinationOptional> destinations = new Vector<DestinationOptional>();
        destinations.add(D1);
        destinations.add(D2);
        destinations.add(D3);

        int [][] costs = {{2,3,1},{5,4,8},{5,6,8}};
        Solution solution = new Solution(sources,destinations,costs);

        solution.addDestination(D2);
        solution.addSource(S2);
        solution.getCost(D1,S1);
        solution.getCost(D2,S2);
        solution.getCost(D3,S1);
        System.out.println("D1 has to pay :  " + solution.getCost(D1));

    }
}

/**
   *  <h1> SourceOptional </h1>
   *  @author : Isac Iulian-George
   *  @version 1.0
   *  @since   2021-02-21
 */
abstract class SourceOptional
{
    String nameSource;
    String adressSource;
    int capacity;
    /**
    * Metoda ce returneaza numele unei surse 
    * @return String
     */
    public abstract String getNameSource();
    /**
    * Metoda ce returneaza adresa sursei
    * @return String
     */
    public abstract String getAdressSource();
   /**
    * Metoda ce returneaza adresa sursei
    * @return String
     */
    public abstract int getCapacity();
    /**
    *  Metoda ce seteaza capacitatea
    *  @return nimic
     */
    public abstract void setCapacity(int capacity);
    /**
    * Metoda ce seteaza adresa
    * @return nimic
     */
    public  abstract void setAdressSource(String adress);
    /**
    * Metoda ce testeaza egalitatea dintre 2 obiecte. 
    * @return boolean 
     */
    public abstract boolean equals( SourceOptional source);

    /**
    * Metoda care seteaza numele sursei . 
    * @return nimic
     */
    public abstract void setNameSource(String nameSource);
    
    /**
    * Metoda ce returneaza o descriere a obiectului . 
    * @return String
    */
    public abstract String toString();
}

/**
   *  <h1> Factory  </h1>
   *  @author : Isac Iulian-George
   *  @version 1.0
   *  @since   2021-02-21
 */

class Factory extends SourceOptional{
    
    /**
    * Metoda ce testeaza egalitatea dintre 2 obiecte. 
    * @return boolean 
     */  
    public boolean equals(SourceOptional source)
    {
        if( (this.getCapacity() == source.getCapacity() ) && (this.getAdressSource() == source.getAdressSource()) && (this.getNameSource() == source.getNameSource()))
        {
            return  true;
        }else{
            return  false;
        }
    }
    /**
    * Metoda care seteaza numele sursei . 
    * @return nimic
    */
    public void setNameSource(String nameSource)
    {
        this.nameSource = nameSource;
    }
    /**
    * Metoda ce seteaza adresa
    * @return nimic
     */
    public void setAdressSource(String adress)
    {
        this.adressSource = adress;
    }
    /**
    *  Metoda ce seteaza capacitatea
    *  @return nimic
    */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
     /**
    * Metoda ce returneaza o descriere a obiectului . 
    * @return String
    */
    public String toString(){
        String res = "\nSource name : " + this.getNameSource() + "\nAdress source : "  + this.getAdressSource() + "\nCapacity : " + this.getCapacity();
        return res;
    }
      /**
    * Metoda ce returneaza numele unei surse 
    * @return String
     */
    public String getNameSource()
    {
        return this.nameSource;
    }
     /**
    * Metoda ce returneaza adresa sursei
    * @return String
     */
    public String getAdressSource(){
        return this.adressSource;
    }
     /**
    * Metoda ce returneaza capacitatea de transport sursei
    * @return int
     */
    public int getCapacity(){
        return this.capacity;
    }
    /**
    * Constructor
    */
    Factory(String name,String adress,int capacity)
    {
        this.setNameSource(name);
        this.setAdressSource(adress);
        this.setCapacity(capacity);
    }
}
/**
   *  <h1> Warehouse  </h1>
   *  @author : Isac Iulian-George
   *  @version 1.0
   *  @since   2021-02-21
 */
class Warehouse extends SourceOptional{
     /**
    * Metoda ce testeaza egalitatea dintre 2 obiecte. 
    * @return boolean 
     */  
    public boolean equals(SourceOptional source)
    {
        if( (this.getCapacity() == source.getCapacity() ) && (this.getAdressSource() == source.getAdressSource()) && (this.getNameSource() == source.getNameSource()))
        {
            return  true;
        }else{
            return  false;
        }
    }
    /**
    * Metoda care seteaza numele sursei . 
    * @return nimic
    */
    public void setNameSource(String nameSource)
    {
        this.nameSource = nameSource;
    }
    /**
    * Metoda ce seteaza adresa
    * @return nimic
     */
    public void setAdressSource(String adress)
    {
        this.adressSource = adress;
    }
    /**
    *  Metoda ce seteaza capacitatea
    *  @return nimic
    */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
     /**
    * Metoda ce returneaza o descriere a obiectului . 
    * @return String
    */
    public String toString(){
        String res = "\nSource name : " + this.getNameSource() + "\nAdress source : "  + this.getAdressSource() + "\nCapacity : " + this.getCapacity();
        return res;
    }
      /**
    * Metoda ce returneaza numele unei surse 
    * @return String
     */
    public String getNameSource()
    {
        return this.nameSource;
    }
     /**
    * Metoda ce returneaza adresa sursei
    * @return String
     */
    public String getAdressSource(){
        return this.adressSource;
    }
     /**
    * Metoda ce returneaza capacitatea de transport sursei
    * @return int
     */
    public int getCapacity(){
        return this.capacity;
    }
    /** 
    *  Constructor
    */
    Warehouse(String name,String adress,int capacity)
    {
        this.setNameSource(name);
        this.setAdressSource(adress);
        this.setCapacity(capacity);
    }
}
/**
   *  <h1> DestinationOptional  </h1>
   *  @author : Isac Iulian-George
   *  @version 1.0
   *  @since   2021-02-21
 */
class DestinationOptional
{
    private  String nameDestination;
    private  String adressDestination;
    private int demand;

    /** 
    *  Metodeaza ce testeaza egalitatea dintre 2 destinatari
    * @return boolean 
    */
    public boolean equals(DestinationOptional destination)
    {
        if((this.nameDestination == destination.getNameDestination()) && (this.adressDestination == destination.getAdressDestination()) && (this.demand == destination.getDemand() )){
            return  true;
        }else{
            return  false;
        }
    }
    /**
    * Metoda ce  returneaza o descriere a unui obiect
    * @return String
     */
    public String toString()
    {
        String res="\n Destination name : " + this.getNameDestination() +  "\n Adress destination: " + this.getAdressDestination() + "\n Demand : " + this.getDemand() + "\n Type destination: " + "\n";
        return res;
    }
    /**
    *  Constructor 
     */
    DestinationOptional(String nameDestination,String adressDestination,int demand)
    {
        this.setNameDestination(nameDestination);
        this.setAdressDestination(adressDestination);
        this.setDemand(demand);

    }
    /**
    *   Metoda ce returneaza numele unui destinatar
    *   @return String 
     */
    public String getNameDestination()
    {
        return this.nameDestination;
    }
    /**
    *  Metoda ce returneaza adresa unui destinatar.
    *  @return String
     */
    public String getAdressDestination(){
        return this.adressDestination;
    }
    /**
    * Metoda ce returneaza cererea unui destinatar. 
    * @return int
     */
    public int getDemand()
    {
        return this.demand;
    }
    /**
    * Metoda ce seteaza numele destinatarului .
    * @return Nothing
     */
    public void setNameDestination(String nameDestination)
    {
        this.nameDestination = nameDestination;
    }
    /**
    * Metoda ce seteaza adresa unui destinatar.
    * @return Nothing
     */
    public void setAdressDestination(String adressDestination)
    {
        this.adressDestination = adressDestination;
    }
    /**
    *  Metoda ce seteaza cererea unei destinatar. 
    *  @return Nothing
     */
    public void setDemand(int demand){
        this.demand = demand;
    }
}

class Solution{
     Vector <SourceOptional> sources;
     Vector <DestinationOptional> destinations;
     int [][] costs;

     /**
     * Metoda ce calculeaza pretul pe care trebuie sa-l plateasca un destinatar unei surse
     * @return Nothing
      */
     public void getCost(DestinationOptional destination,SourceOptional source)
     {
         if((destinations.contains(destination)) && (sources.contains(source)))
         {
             if(destination.getDemand() > source.getCapacity())
             {
                 System.out.println("Source " + source.getNameSource() + "->" + destination.getNameDestination() + "  : " + source.getCapacity() *costs[sources.indexOf(source)][destinations.indexOf(destination)]);
             }else{
                 System.out.println("Source " + source.getNameSource() + "->" + destination.getNameDestination() + "  : " + destination.getDemand()*costs[sources.indexOf(source)][destinations.indexOf(destination)]);
             }
         }else{
             System.out.println("Sorry we can't find that ! ");
         }
     }
    /**
     * Metoda ce calculeaza pretul pe care trebuie sa-l plateasca .
     * @param destination - destinatarul 
     * @return int
      */
     public int getCost(DestinationOptional destination)
     {

         if(destinations.contains(destination))
         {
             int cost = 0;
             for(int i =0 ;i<sources.size();i++)
             {
                 if(sources.elementAt(i).getCapacity() < destination.getDemand())
                 {
                     cost = cost + sources.elementAt(i).getCapacity() * costs[i][destinations.indexOf(destination)];
                 }else{
                     cost = cost + destination.getDemand() * costs[i][destinations.indexOf(destination)];
                 }
             }
             return  cost;
         }else{
             return 0;
         }
     }
    /**
    *  Metoda ce adauga o sursa la lista de surse
    * @param source -sursa
    * @return Nimic 
     */
    public void addSource(SourceOptional source)
    {
        if(sources.contains(source))
        {
            System.out.println("This source can't be added again in the list");
        }else{
            sources.add(source);
        }
    }
    /**
    *  Metoda ce adauga un destinatar la lista de destinatari
    * @param destination - destinatarul
    * @return Nimic 
     */
    public void addDestination(DestinationOptional destination)
    {
         if(destinations.contains(destination))
         {
             System.out.println("This destination can't be added again in the list");
         }else{
             destinations.add(destination);
         }
    }
    /**
    * Metoda ce seteaza matricea de costuri . 
    * @return void
     */
    public void setCosts(int [][] costs)
    {
        this.costs = costs;
    }
    /**
    * Metoda ce seteaza lista de surse
    * @return nimic
     */
    public void setSources (Vector<SourceOptional> sources)
    {
        this.sources = sources;
    }
    /**
    * Metoda ce seteaza lista de destinatari
    * @return nimic
     */
    public void setDestinations(Vector<DestinationOptional> destinations)
    {
        this.destinations = destinations;
    }
    /**
    * Metoda ce returneaza matricea de costuri
    * @return int[][]
     */
    public int [][] getCosts ()
    {
        return  this.costs;
    }
    /**
    *  Metoda ce returneaza lista de destinatari .
    *  @return Vector<DestinationOptional>
     */
    public Vector<DestinationOptional> getDestinations()
    {
        return  destinations;
    }
    /**
    *  Constructor .
     */
    Solution(Vector<SourceOptional>sources,Vector<DestinationOptional>destinations,int [][] costs)
    {
        this.setSources(sources);
        this.setDestinations(destinations);
        this.setCosts(costs);
    }
    /**
    *  Metoda ce returneaza lista de surse .
    *  @return Vector<SourceOptional>
     */
    public Vector<SourceOptional> getSources()
    {
        return sources;
    }
}