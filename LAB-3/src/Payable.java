/**
 * <h4> Payable </h4>
 * @author : Isac Iulian-George
  * Implementarea interfetei Payable
 */
interface Payable {
    /**
     * Setter pentru pretul unui bilet .
     * @param price
     * @return void
     */
     public void setPriceTicket(double price);
    /**
     * Getter pentru pretul unui bilet .
     * @return double
     */
    public double getPriceTicket();
}
