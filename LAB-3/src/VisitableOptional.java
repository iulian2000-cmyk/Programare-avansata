/**
 * <h1> VisitableOptional </h1>
 * @author  : Isac Iulian-George
 * Implementarea interfetei VisitableOptional
 */
import com.sun.jdi.request.DuplicateRequestException;

import java.time.Duration;
import java.time.LocalTime;

interface VisitableOptional {

    LocalTime openingHour=LocalTime.of(9,30);
    LocalTime closingHour=LocalTime.of(20,0);

    /**
     * Metoda definita static .
     * @return Duration
     */
    static Duration getDuration(){
        return Duration.between(openingHour,closingHour);
    }

    /**
     * @return void
     */
    default void showProgram()
    {
        System.out.println("The showProgram() was called : " + openingHour + "-" + closingHour);
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

