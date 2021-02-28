/**
 * <h1> VisitableOptional </h1>
 * @author  : Isac Iulian-George
 * Implementarea interfetei VisitableOptional
 */
import java.time.Duration;
import java.time.LocalTime;

interface VisitableOptional {

    LocalTime openingHour = LocalTime.of(9,30);
    LocalTime closingHour =  LocalTime.of(20,0,0);

    static Duration getDuration() {
        return Duration.between(openingHour,closingHour);
    }

    /**
     * @return void
     */
    default void showProgram()
    {
        System.out.println(openingHour +"-"+closingHour);
    }
    /**
     * Setter pentru ora deschiderii locatiei .
     * @param time
     */
    public void setOpeningHour(LocalTime time);

    /**
     * Setter pentru ora inchiderii .
     * @param time
     */
    public void setClosingHour(LocalTime time);

    /**
     * Getter pentru ora deschiderii .
     * @return LocalTime
     */
    public LocalTime getOpeningHour();
    /**
     * Getter pentru ora inchiderii .
     * @return LocalTime
     */
    public LocalTime getClosingHour();
}

