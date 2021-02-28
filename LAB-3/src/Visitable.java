/**
 * <h2> Visitable </h2>
 * @author  : Isac Iulian-George
 * Implementarea interfetei Visitable
 */
interface Visitable {
    /**
     * Setter pentru ora deschiderii locatiei .
     * @param openingHour
     */
    public void setOpeningHour(String openingHour);

    /**
     * Setter pentru ora inchiderii .
     * @param closingHour
     */
    public void setClosingHour(String closingHour);

    /**
     * Getter pentru ora deschiderii .
     * @return String
     */
    public String getOpeningHour();
    /**
     * Getter pentru ora inchiderii .
     * @return String
     */
    public String getClosingHour();
}
