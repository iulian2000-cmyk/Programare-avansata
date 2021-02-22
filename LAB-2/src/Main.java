

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Crearea obiectelor de tipul Source folosind constructorul implementat
        Source Source1 = new Source("S1", "X", 10, SourceType.FACTORY);
        Source Source2 = new Source("S2", "Y", 35, SourceType.WAREHOUSE);
        Source Source3 = new Source("S3", "Z", 25, SourceType.WAREHOUSE);

        // Crearea obiectelor de tipul Destination folosind constructorul implementat
        Destination Destination1 = new Destination("D1", "L", 20, DestinationType.COMPANY);
        Destination Destination2 = new Destination("D2", "M", 20, DestinationType.INDIVIDUAL);
        Destination Destionation3 = new Destination("D3", "P", 25, DestinationType.INSTITUTION);

        // Crearea si popularea listelor de surse , respectiv de destinatari;
        Vector<Source> sources = new Vector<Source>();
        Vector<Destination> destinations = new Vector<Destination>();

        sources.add(Source1);
        sources.add(Source2);
        sources.add(Source3);

        destinations.add(Destination1);
        destinations.add(Destination2);
        destinations.add(Destionation3);


        int[][] costs = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Problem problem = new Problem(sources, destinations, costs);

        // Apelarea metodei toString() pentru obiectele de tipul Source
        System.out.println(Source1.toString());
        System.out.println(Source2.toString());
        System.out.println(Source3.toString());

        // Apelarea metodei toString() pentru obiectele de tipul Destination
        System.out.println(Destination1.toString());
        System.out.println(Destination2.toString());
        System.out.println(Destionation3.toString());

        // Apelarea metodei toString() pentru obiectele de tipul Problem
        System.out.println(problem.toString());
        // Apelarea metodei getCost(Destination destination)
        System.out.println("The cost made by D1 is  " + problem.getCost(Destination1));
        System.out.println("The cost made by D2 is  " + problem.getCost(Destination2));
        System.out.println("The cost made by D3 is  " + problem.getCost(Destionation3));

        // Apelarea metodei getCost(Destination destination,Source source)
        problem.getCost(Source1, Destination1);
        problem.getCost(Source1, Destination2);
        problem.getCost(Source1, Destionation3);
        problem.getCost(Source2, Destination1);
        problem.getCost(Source2, Destination2);
        problem.getCost(Source2, Destionation3);
        problem.getCost(Source3, Destination1);
        problem.getCost(Source3, Destination2);
        problem.getCost(Source3, Destionation3);
    }
}




