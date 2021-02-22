

import java.util.*;

public class Main {

    public static void main(String[] args) {

         // Crearea obiectelor de tipul Source folosind constructorul implementat
         Source S1 = new Source ("S1","X",10,SourceType.FACTORY);
         Source S2 = new Source ("S2","Y",35,SourceType.WAREHOUSE);
         Source S3 = new Source ("S3","Z",25,SourceType.WAREHOUSE);

         // Crearea obiectelor de tipul Destination folosind constructorul implementat
         Destination D1 = new Destination("D1","L",20,DestinationType.COMPANY);
         Destination D2 = new Destination("D2","M",20,DestinationType.INDIVIDUAL);
         Destination D3 = new Destination("D3","P",25,DestinationType.INSTITUTION);

         // Crearea si popularea listelor de surse , respectiv de destinatari;
         Vector<Source> sources = new Vector<Source>();
         Vector<Destination>destinations = new Vector<Destination>();

         sources.add(S1);
         sources.add(S2);
         sources.add(S3);

         destinations.add(D1);
         destinations.add(D2);
         destinations.add(D3);



         int [][] costs = {{2,3,1},{5,4,8},{5,6,8}};
         Problem problem = new Problem(sources,destinations,costs);

         // Apelarea metodei toString() pentru obiectele de tipul Source
         System.out.println(S1.toString());
         System.out.println(S2.toString());
         System.out.println(S3.toString());
         // Apelarea metodei toString() pentru obiectele de tipul Destination
         System.out.println(D1.toString());
         System.out.println(D2.toString());
         System.out.println(D3.toString());

         // Apelarea metodei toString() pentru obiectele de tipul Problem

        System.out.println(problem.toString());

         // Apelarea metodei getCost(Destination destination)
         System.out.println("The cost made by D1 is  " + problem.getCost(D1));
         System.out.println("The cost made by D2 is  " + problem.getCost(D2));
         System.out.println("The cost made by D3 is  " + problem.getCost(D3));

         // Apelarea metodei getCost(Destination destination,Source source)
         problem.getCost(S1,D1);
         problem.getCost(S1,D2);
         problem.getCost(S1,D3);
         problem.getCost(S2,D1);
         problem.getCost(S2,D2);
         problem.getCost(S2,D3);
         problem.getCost(S3,D1);
         problem.getCost(S3,D2);
         problem.getCost(S3,D3);
    }
}
// Obiecte de tipul "enum" pentru a stoca tipul destinatorului/sursei .
enum DestinationType{
            INDIVIDUAL,INSTITUTION,COMPANY;
        }
 enum SourceType {
    WAREHOUSE, FACTORY;
}



class Destination
{
    private  String nameDestination;
    private  String adressDestination;
    private int demand;
    public DestinationType type;

    
    /**
     * Metoda folosita pentru ilustrarea informatiilor despre un destinatar , fiind implementata folosing gettere .
     * @return String returneaza un sir de caractere ce reprezinta descrierea obiectului in sine folosindu-se de atributele acestuia . 
    */
    
    public String toString()
    {
        String res="\n Destination name : " + this.getNameDestination() +  "\n Adress destination: " + this.getAdressDestination() + "\n Demand : " + this.getDemand() + "\n Type destination: " + this.getType() + "\n";
        return res;
    }
    /**
    * Constructor   
    */
    Destination(String nameDestination,String adressDestination,int demand,DestinationType type)
    {
        this.setNameDestination(nameDestination);
        this.setAdressDestination(adressDestination);
        this.setDemand(demand);
        this.setType(type);
    }
    /**
    * Metoda folosita pentru a returna tipul de destinatar
    * @return DestinationType 
     */
    public DestinationType getType()
    {
        return this.type;
    }
     /**
    * Metoda folosita pentru a returna numele destinatarului 
    * @return String
     */
    public String getNameDestination()
    {
        return this.nameDestination;
    }
    /**
    * Metoda folosita pentru a returna adresa destinatarului 
    * @return String
     */
    public String getAdressDestination(){
        return this.adressDestination;
    }
     /**
    * Metoda folosita pentru a returna volumul cererii destinatarului 
    * @return int
     */
    public int getDemand()
    {
        return this.demand;
    }
     /**
    * Metoda folosita pentru a seta tipul destinatarului 
    * @return Nimic
     */
    public void setType(DestinationType type)
    {
        this.type = type;
    }
    /**
    * Metoda folosita pentru a seta numele destinatarului 
    * @return Nimic
     */
    public void setNameDestination(String nameDestination)
    {
        this.nameDestination = nameDestination;
    }
     /**
    * Metoda folosita pentru a seta adresa destinatarului 
    * @return Nimic
     */
    public void setAdressDestination(String adressDestination)
    {
        this.adressDestination = adressDestination;
    }
     /**
    * Metoda folosita pentru a seta cererea destinatarului 
    * @return Nimic
     */
    public void setDemand(int demand){
        this.demand = demand;
    }
}

class Source{
    // Atribute private precum numele,adresa si capacitatea de transport a sursei , publice tipul .
    private String nameSource;
    private String adressSource;
    private int capacity;
    public SourceType type;

    /** 
       * Metoda ce returneaza tipul de sursa .
       * @return SourceType
     */
    public SourceType getType()
    {
        return this.type;
    }
    /**
    * Metoda ce returneaza numele sursei .
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
    public String getAdressSource()
    {
        return this.adressSource;
    }
    /**
    * Metoda returneaza capacitatea de transport a sursei
    * @return int 
     */
    public int getCapacity()
    {
        return this.capacity;
    }
     /**
    * Metoda folosita pentru a seta tipul sursei .  
    * @return Nimic
     */
    public void setType(SourceType type)
    {
        this.type = type;
    }
     /**
    * Metoda folosita pentru a seta capacitatea de transport .  
    * @return Nimic
     */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
     /**
    * Metoda folosita pentru a seta adresa sursei .  
    * @return Nimic
     */
    public  void setAdressSource(String adress)
    {
        this.adressSource = adress;
    }
     /**
    * Metoda folosita pentru a seta numele sursei .  
    * @return Nimic
    */
    public void setNameSource(String nameSource)
    {
        this.nameSource = nameSource;
    }
    /**
    * Metoda folosita pentru a returna o descriere a obiectului folosindu-se de gettere. 
    * @return String
    */
    public String toString()
    {
        String res ="Source name " + this.getNameSource() + "\n Source adress :" + this.getAdressSource() + "\nSource type : " + this.getType() + "\n Source capacity : " + this.getCapacity() + "\n";
        return res;
    }
    /**
       Constructor 
     */
    Source(String Name,String adress,int capacity,SourceType type)
    {
        this.setNameSource(Name);
        this.setAdressSource(adress);
        this.setCapacity(capacity);
        this.setType(type);
    }
}


class Problem
{
    // Membri privati , lista de surse si cea de destinatari , respectiv matricea cu costurile de transport in functie de destinatar si sursa
    private Vector <Source> sources;
    private Vector <Destination> destinations;
    private int [][] costs;


    /**
    * Metoda ce adauga o sursa in lista de surse . 
    * @param source - unde "source" reprezinta sursa ce trebuie adaugata in lista
    * @return Nimic
     */
    public void addSource(Source source)
    {
        sources.add(source);
    }
    
    /**
    * Metoda ce adauga un destinatar in lista de destinatari.
    * @param destination - unde "destination" reprezinta destinatarul ce trebuie adaugata in lista
    * @return Nimic
     */
    public void addDestination(Destination destination)
    {
        destinations.add(destination);
    }
    /**
    * Metoda ce seteaza costurile de transport . 
    * @param costs - costurile care vor fi setate .
    * @return Nimic
     */    
    public void setCosts(int [][] costs)
    {
        this.costs = costs;
    }
    /**
    * Metoda ce seteaza lista de surse 
    * @param sources - lista de surse ce va fi setata . 
    * @return Nimic
    */  
    public void setSources (Vector<Source> sources)
    {
        this.sources = sources;
    }
    /**
    * Metoda ce seteaza lista de destinatari. 
    * @param destinations - lista de destinatari care va fi setata . 
    * @return Nimic
    */  
    public void setDestinations(Vector<Destination> destinations)
    {
        this.destinations = destinations;
    }
    /**
    * Metoda ce returneaza matrice de costuri . 
    * @return int [][]
    */  
    public int [][] getCosts ()
    {
        return  this.costs;
    }
    /**
    * Metoda ce returneaza lista de destinatari .
    * @return Vector<Destination>
    */  
    public Vector<Destination> getDestinations()
    {
        return  destinations;
    }
    /**
    * Metoda ce returneaza lista de surse . 
    * @return Vector<Source>
    */  
    public Vector<Source> getSources()
    {
        return sources;
    }
    /**
       Constructor 
    */
    Problem(Vector<Source> sources, Vector<Destination> destinations, int [][] costs)
    {
        this.sources = new Vector<>();
        this.setSources(sources);

        this.destinations = new Vector<>();
        this.setDestinations(destinations);

        this.costs = new int [sources.size()][destinations.size()];
        this.setCosts(costs);
    }
    /**
    *  Metoda ce determina costul total de transport de la toate sursele. 
    *  @param destination - destinatarul pentru care se gaseste costul
    *  @return int 
     */
    public int getCost(Destination destination)
    {
        if(!destinations.contains(destination))
        {
            return  0;
        }else{
             int cost = 0;
             for(int i =0 ;i<sources.size();i++)
             {
                 cost = cost + destination.getDemand()*costs[i][destinations.indexOf(destination)];
             }
             return  cost;
        }
    }
    /**
    *  Metoda ce determina costul transportului de la o sursa de la un destinatar. 
    *  @param destination - destinatarul 
    *  @param source - sursa 
    *  @return nimic
     */
    public void getCost(Source source,Destination destination)
    {
        if((!sources.contains(source)) || (!destinations.contains(destination)))
        {
             System.out.println("The source or the destination can be found in the problem ! ");
        }else{
            if((sources.contains(source)&&(!destinations.contains(destination)))){
                System.out.println("The destination is not in the problem");
            }else{
                if((!sources.contains(source)&&(destinations.contains(destination)))){
                    System.out.println("The source is not in the problem");
                }else{
                    System.out.println("Source " + source.getNameSource() + "->" + destination.getNameDestination() + "  : " + destination.getDemand()*costs[sources.indexOf(source)][destinations.indexOf(destination)]);
                }
            }
        }
    }
    /**
     * Metoda care printeaza un mesaj
     * @return Nimic .
     */
    public String toString()
    {
       String result = "\nThis was the problem !";
       return  result;
    }
}