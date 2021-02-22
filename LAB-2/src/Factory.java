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
        if( (this.getCapacity() == source.getCapacity() ) && (this.getAdress() == source.getAdress()) && (this.getName() == source.getName()))
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
        this.name = nameSource;
    }
    /**
     * Metoda ce seteaza adresa
     * @return nimic
     */
    public void setAdress(String adress)
    {
        this.adress = adress;
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
        String res = "\nSource name : " + this.getName() + "\nAdress source : "  + this.getAdress() + "\nCapacity : " + this.getCapacity();
        return res;
    }
    /**
     * Metoda ce returneaza numele unei surse
     * @return String
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Metoda ce returneaza adresa sursei
     * @return String
     */
    public String getAdress(){
        return this.adress;
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
        this.setAdress(adress);
        this.setCapacity(capacity);
    }
}