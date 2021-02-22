
/**
 *  <h1> SourceOptional </h1>
 *  @author : Isac Iulian-George
 *  @version 1.0
 *  @since   2021-02-21
 */
abstract class SourceOptional
{
    String name;
    String adress;
    int capacity;
    /**
     * Metoda ce returneaza numele unei surse
     * @return String
     */
    public abstract String getName();
    /**
     * Metoda ce returneaza adresa sursei
     * @return String
     */
    public abstract String getAdress();
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
    public  abstract void setAdress(String adress);
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