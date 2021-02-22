
enum SourceType {
    WAREHOUSE, FACTORY;
}
class Source {
    // Atribute private precum numele,adresa si capacitatea de transport a sursei , publice tipul .
    private String nameSource;
    private String address;
    private int capacity;
    public SourceType type;

    /**
     * Metoda ce returneaza tipul de sursa .
     *
     * @return SourceType
     */
    public SourceType getType() {
        return this.type;
    }

    /**
     * Metoda ce returneaza numele sursei .
     *
     * @return String
     */

    public String getNameSource() {
        return this.nameSource;
    }

    /**
     * Metoda ce returneaza adresa sursei
     *
     * @return String
     */
    public String getAdressSource() {
        return this.address;
    }

    /**
     * Metoda returneaza capacitatea de transport a sursei
     *
     * @return int
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Metoda folosita pentru a seta tipul sursei .
     *
     * @return Nimic
     */
    public void setType(SourceType type) {
        this.type = type;
    }

    /**
     * Metoda folosita pentru a seta capacitatea de transport .
     *
     * @return Nimic
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Metoda folosita pentru a seta adresa sursei .
     *
     * @return Nimic
     */
    public void setAdressSource(String adress) {
        this.address = adress;
    }

    /**
     * Metoda folosita pentru a seta numele sursei .
     *
     * @return Nimic
     */
    public void setNameSource(String nameSource) {
        this.nameSource = nameSource;
    }

    /**
     * Metoda folosita pentru a returna o descriere a obiectului folosindu-se de gettere.
     *
     * @return String
     */
    public String toString() {
        String res = "Source name " + this.getNameSource() + "\n Source adress :" + this.getAdressSource() + "\nSource type : " + this.getType() + "\n Source capacity : " + this.getCapacity() + "\n";
        return res;
    }

    /**
     * Constructor
     */
    Source(String Name, String adress, int capacity, SourceType type) {
        this.setNameSource(Name);
        this.setAdressSource(adress);
        this.setCapacity(capacity);
        this.setType(type);
    }
}