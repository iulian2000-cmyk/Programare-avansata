/**
 *  <h1> DestinationOptional  </h1>
 *  @author : Isac Iulian-George
 *  @version 1.0
 *  @since   2021-02-21
 */
class DestinationOptional
{
    private  String nameDestination;
    private  String adressDestination;
    private int demand;

    /**
     *  Metodeaza ce testeaza egalitatea dintre 2 destinatari
     * @return boolean
     */
    public boolean equals(DestinationOptional destination)
    {
        if((this.nameDestination == destination.getNameDestination()) && (this.adressDestination == destination.getAdressDestination()) && (this.demand == destination.getDemand() )){
            return  true;
        }else{
            return  false;
        }
    }
    /**
     * Metoda ce  returneaza o descriere a unui obiect
     * @return String
     */
    public String toString()
    {
        String res="\n Destination name : " + this.getNameDestination() +  "\n Adress destination: " + this.getAdressDestination() + "\n Demand : " + this.getDemand() + "\n Type destination: " + "\n";
        return res;
    }
    /**
     *  Constructor
     */
    DestinationOptional(String nameDestination,String adressDestination,int demand)
    {
        this.setNameDestination(nameDestination);
        this.setAdressDestination(adressDestination);
        this.setDemand(demand);

    }
    /**
     *   Metoda ce returneaza numele unui destinatar
     *   @return String
     */
    public String getNameDestination()
    {
        return this.nameDestination;
    }
    /**
     *  Metoda ce returneaza adresa unui destinatar.
     *  @return String
     */
    public String getAdressDestination(){
        return this.adressDestination;
    }
    /**
     * Metoda ce returneaza cererea unui destinatar.
     * @return int
     */
    public int getDemand()
    {
        return this.demand;
    }
    /**
     * Metoda ce seteaza numele destinatarului .
     * @return Nothing
     */
    public void setNameDestination(String nameDestination)
    {
        this.nameDestination = nameDestination;
    }
    /**
     * Metoda ce seteaza adresa unui destinatar.
     * @return Nothing
     */
    public void setAdressDestination(String adressDestination)
    {
        this.adressDestination = adressDestination;
    }
    /**
     *  Metoda ce seteaza cererea unei destinatar.
     *  @return Nothing
     */
    public void setDemand(int demand){
        this.demand = demand;
    }
}