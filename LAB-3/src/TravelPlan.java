/**
 * <h13>TravelPlan</h13>
 * @author  Isac Iulian-George
 */
import  java.util.*;
class TravelPlan {
    private City city;
    private Queue<Location> order;
    private double [][] adjacencyMatrixOfLocations;

    public double [][] getAdjacencyMatrixOfLocations()
    {
        return adjacencyMatrixOfLocations;
    }
    public boolean areClose(Location A,Location B)
    {
        Iterator<Map.Entry<Location, Double> > iterator = A.getTimesBetweenLocations().entrySet().iterator();
        boolean isKeyPresent = false;
        while (iterator.hasNext()) {
            Map.Entry<Location, Double> entry = iterator.next();
            if ( B == entry.getKey()) {
                isKeyPresent = true;
            }
        }
        return isKeyPresent;
    }
    /**
    *  Constructor
    *  @param city - city of the travel plan
    *  @param order - the order of visiting
    */
    TravelPlan(City city, Queue<Location>order)
    {
        this.city = new City(city.getLocationList());
        this.order = order;
        adjacencyMatrixOfLocations = new double[order.size()][order.size()];
        Location [] tempVector = order.toArray(new Location [order.size()]);
        for(int i=0;i<order.size();i++)
        {
            for(int j=0;j<order.size();j++) {
                if (i == j) {
                    adjacencyMatrixOfLocations[i][j] = 0;
                }else{
                    if(areClose(tempVector[i],tempVector[j]))
                    {
                        adjacencyMatrixOfLocations[i][j]= tempVector[i].getTimeLocation(tempVector[j]);
                        adjacencyMatrixOfLocations[j][i] = adjacencyMatrixOfLocations[i][j];
                    }else{
                        adjacencyMatrixOfLocations[i][j]=0;
                    }
                    if(areClose(tempVector[j],tempVector[i]))
                    {
                        adjacencyMatrixOfLocations[i][j]=tempVector[j].getTimeLocation(tempVector[i]);
                        adjacencyMatrixOfLocations[j][i]=adjacencyMatrixOfLocations[i][j];
                    }
                }
            }
        }
    }
    /**
    *   Metoda ce determina toate drumurile cele mai scurte de la un nod dat catre celalalte noduri bazandu-ste pe algoritmul lui Dijkstra .
    *   @param adjacencyMatrix - matricea de adiacenta
    *   @param startVertex - index-ul locatiei de inceput 
    *   LINK : https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
    */
    public  void ShowAllPaths(double[][] adjacencyMatrix, int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;
        double [] shortestDistances = new double[nVertices];
        boolean[] added = new boolean[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        shortestDistances[startVertex] = 0;
        int[] parents = new int[nVertices];
        parents[startVertex] = -1;
        for (int i = 1; i < nVertices; i++)
        {
            int nearestVertex = -1;
            double shortestDistance = Double.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] <  shortestDistance )
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            added[nearestVertex] = true;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
        printSolution(startVertex, shortestDistances, parents);
    }
    public  void printSolution(int startVertex, double[] distances, int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("             \t Distance   \tPath");
        Location [] locations = order.toArray(new Location[order.size()]);
        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                    System.out.print("\n" + locations[startVertex].getName() + " -> ");
                    System.out.print(locations[vertexIndex].getName() + " \t\t ");
                    System.out.print(distances[vertexIndex] + "\t\t");
                    printPath(vertexIndex, parents);
            }
        }
    }
    public  void printPath(int currentVertex, int[] parents)
    {
        Location [] loc = order.toArray(new Location[order.size()]);
        if (currentVertex == -1)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(loc[currentVertex].getName() + " ");
    }
}
