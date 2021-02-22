
enum DestinationType {
    INDIVIDUAL, INSTITUTION, COMPANY;
}
class Destination {
    private String name;
    private String address;
    private int demand;
    public DestinationType type;
    /**
     * Metoda folosita pentru ilustrarea informatiilor despre un destinatar , fiind implementata folosing gettere .
     *
     * @return String returneaza un sir de caractere ce reprezinta descrierea obiectului in sine folosindu-se de atributele acestuia .
     */

    public String toString() {
        String res = "\n Destination name : " + this.getName() + "\n Adress destination: " + this.getAdressDestination() + "\n Demand : " + this.getDemand() + "\n Type destination: " + this.getType() + "\n";
        return res;
    }

    /**
     * Constructor
     */
    Destination(String name, String adressDestination, int demand, DestinationType type) {
        this.setname(name);
        this.setAdressDestination(adressDestination);
        this.setDemand(demand);
        this.setType(type);
    }

    /**
     * Metoda folosita pentru a returna tipul de destinatar
     *
     * @return DestinationType
     */
    public DestinationType getType() {
        return this.type;
    }

    /**
     * Metoda folosita pentru a returna numele destinatarului
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Metoda folosita pentru a returna adresa destinatarului
     *
     * @return String
     */
    public String getAdressDestination() {
        return this.address;
    }

    /**
     * Metoda folosita pentru a returna volumul cererii destinatarului
     *
     * @return int
     */
    public int getDemand() {
        return this.demand;
    }

    /**
     * Metoda folosita pentru a seta tipul destinatarului
     *
     * @return Nimic
     */
    public void setType(DestinationType type) {
        this.type = type;
    }

    /**
     * Metoda folosita pentru a seta numele destinatarului
     *
     * @return Nimic
     */
    public void setname(String name) {
        this.name = name;
    }

    /**
     * Metoda folosita pentru a seta adresa destinatarului
     *
     * @return Nimic
     */
    public void setAdressDestination(String adressDestination) {
        this.address = adressDestination;
    }

    /**
     * Metoda folosita pentru a seta cererea destinatarului
     *
     * @return Nimic
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }
}
