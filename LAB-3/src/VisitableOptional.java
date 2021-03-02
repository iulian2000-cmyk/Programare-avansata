/**
 * <h1> VisitableOptional </h1>
 * @author  : Isac Iulian-George
 * Implementarea interfetei VisitableOptional
 */
import com.sun.jdi.request.DuplicateRequestException;

import java.time.Duration;
import java.time.LocalTime;

interface VisitableOptional {

    LocalTime openingHour = LocalTime.of(9, 30);
    LocalTime closingHour = LocalTime.of(12, 0);

    static Duration getDuration() {
        return Duration.between(openingHour, closingHour);
    }

    /**
     * Setter pentru ora de start
     *
     * @param time
     */
    void setOpeningHour(LocalTime time);

    /**
     * Metoda default folosita in cadrul constructorilor clasei "ChurchOptional" si "MuseumOptional"
     * @param time
     */
    default void setOpeningHourDefault(LocalTime time) {
        this.setOpeningHour(time);
    }

    /**
     * Setter pentru ora inchiderii
     *
     * @param time
     */
    void setClosingHour(LocalTime time);

    default void setClosingHourDefault(LocalTime time) {
        this.setClosingHour(time);
    }

    /**
     * Getter pentru ora de start
     */
    LocalTime getOpeningHour();

    default LocalTime getOpeningHourDefault() {
        return this.getOpeningHour();
    }

    /**
     * Getter pentru ora de sfarsit
     *
     * @return LocalTime
     */
    LocalTime getClosingHour();

    default LocalTime getClosingHourDefault() {
        return this.getClosingHour();
    }
}

