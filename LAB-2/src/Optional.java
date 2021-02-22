/**
    *  @author : Isac Iulian-George
    *  @version 1.0
    *  @since   2021-02-21
 */
import java.util.*;

public class Optional {
    public static void main(String[] args) {

          /** Crearea obiectelor S1,S2 si S3 si S4 ( ultimul fiind folosit pentru a testa egalitatea dintre obiecte ) */
          SourceOptional Source1 = new Factory("S1","X",10);
          SourceOptional Source2 = new Warehouse("S2","Y",35);
          SourceOptional Source3 = new Warehouse("S3","Z",25);
          SourceOptional Source4 = new Warehouse("S3","Z",25);
          /** Crearea obiectelor D1,D2 si D3 */

         DestinationOptional Destination1 = new DestinationOptional("D1","T",20);
         DestinationOptional Destination2 = new DestinationOptional("D2","P",25);
         DestinationOptional Destination3 = new DestinationOptional( "D3","K",25);

         /** Testarea metodei equals(); */
        if(Source3.equals(Source4))
        {
            System.out.println("S3 and S4 are the same object .");
        }

        /** Crearea vectorilor cu surse , respectiv de destinatari .*/

        Vector <SourceOptional> sources = new Vector<SourceOptional>();
        sources.add(Source1);
        sources.add(Source2);
        sources.add(Source3);

        Vector<DestinationOptional> destinations = new Vector<DestinationOptional>();
        destinations.add(Destination1);
        destinations.add(Destination2);
        destinations.add(Destination3);

        int [][] costs = {{2,3,1},{5,4,8},{5,6,8}};
        Solution solution = new Solution(sources,destinations,costs);

        solution.addDestination(Destination2);
        solution.addSource(Source2);
        solution.getCost(Destination1,Source1);
        solution.getCost(Destination2,Source2);
        solution.getCost(Destination3,Source1);
        System.out.println("D1 has to pay :  " + solution.getCost(Destination1));

    }
}