import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.with(TemporalAdjusters.dayOfWeekInMonth(3,DayOfWeek.THURSDAY)));
    }
}
