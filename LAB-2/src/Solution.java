import java.util.Vector;

/**
 *  <h1> Solution  </h1>
 *  @author : Isac Iulian-George
 *  @version 1.0
 *  @since   2021-02-21
 */
class Solution{
    Vector<SourceOptional> sources;
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
                System.out.println("Source " + source.getName() + "->" + destination.getNameDestination() + "  : " + source.getCapacity() *costs[sources.indexOf(source)][destinations.indexOf(destination)]);
            }else{
                System.out.println("Source " + source.getName() + "->" + destination.getNameDestination() + "  : " + destination.getDemand()*costs[sources.indexOf(source)][destinations.indexOf(destination)]);
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