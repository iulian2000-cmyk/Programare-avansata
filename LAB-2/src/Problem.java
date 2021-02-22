import java.util.Vector;

class Problem {
    // Membri privati , lista de surse si cea de destinatari , respectiv matricea cu costurile de transport in functie de destinatar si sursa
    private Vector<Source> sources;
    private Vector<Destination> destinations;
    private int[][] costs;


    /**
     * Metoda ce adauga o sursa in lista de surse .
     *
     * @param source - unde "source" reprezinta sursa ce trebuie adaugata in lista
     * @return Nimic
     */
    public void addSource(Source source) {
        sources.add(source);
    }

    /**
     * Metoda ce adauga un destinatar in lista de destinatari.
     *
     * @param destination - unde "destination" reprezinta destinatarul ce trebuie adaugata in lista
     * @return Nimic
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Metoda ce seteaza costurile de transport .
     *
     * @param costs - costurile care vor fi setate .
     * @return Nimic
     */
    public void setCosts(int[][] costs) {
        this.costs = costs;
    }

    /**
     * Metoda ce seteaza lista de surse
     *
     * @param sources - lista de surse ce va fi setata .
     * @return Nimic
     */
    public void setSources(Vector<Source> sources) {
        this.sources = sources;
    }

    /**
     * Metoda ce seteaza lista de destinatari.
     *
     * @param destinations - lista de destinatari care va fi setata .
     * @return Nimic
     */
    public void setDestinations(Vector<Destination> destinations) {
        this.destinations = destinations;
    }

    /**
     * Metoda ce returneaza matrice de costuri .
     *
     * @return int [][]
     */
    public int[][] getCosts() {
        return this.costs;
    }

    /**
     * Metoda ce returneaza lista de destinatari .
     *
     * @return Vector<Destination>
     */
    public Vector<Destination> getDestinations() {
        return destinations;
    }

    /**
     * Metoda ce returneaza lista de surse .
     *
     * @return Vector<Source>
     */
    public Vector<Source> getSources() {
        return sources;
    }

    /**
     * Constructor
     */
    Problem(Vector<Source> sources, Vector<Destination> destinations, int[][] costs) {
        this.sources = new Vector<>();
        this.setSources(sources);

        this.destinations = new Vector<>();
        this.setDestinations(destinations);

        this.costs = new int[sources.size()][destinations.size()];
        this.setCosts(costs);
    }

    /**
     * Metoda ce determina costul total de transport de la toate sursele.
     *
     * @param destination - destinatarul pentru care se gaseste costul
     * @return int
     */
    public int getCost(Destination destination) {
        if (!destinations.contains(destination)) {
            return 0;
        } else {
            int cost = 0;
            for (int i = 0; i < sources.size(); i++) {
                cost = cost + destination.getDemand() * costs[i][destinations.indexOf(destination)];
            }
            return cost;
        }
    }

    /**
     * Metoda ce determina costul transportului de la o sursa de la un destinatar.
     *
     * @param destination - destinatarul
     * @param source      - sursa
     * @return nimic
     */
    public void getCost(Source source, Destination destination) {
        if ((!sources.contains(source)) || (!destinations.contains(destination))) {
            System.out.println("The source or the destination can be found in the problem ! ");
        } else {
            if ((sources.contains(source) && (!destinations.contains(destination)))) {
                System.out.println("The destination is not in the problem");
            } else {
                if ((!sources.contains(source) && (destinations.contains(destination)))) {
                    System.out.println("The source is not in the problem");
                } else {
                    System.out.println("Source " + source.getNameSource() + "->" + destination.getName() + "  : " + destination.getDemand() * costs[sources.indexOf(source)][destinations.indexOf(destination)]);
                }
            }
        }
    }
    /**
     * Metoda care printeaza un mesaj
     *
     * @return Nimic .
     */
    public String toString() {
        String result = "\nThis was the problem !";
        return result;
    }
}