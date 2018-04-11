import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class NextHoliday implements TemporalAdjuster {

    private static ArrayList<MonthDay> holidays = new ArrayList<>(List.of(
            MonthDay.of(Month.JANUARY, 1),
            MonthDay.of(Month.JANUARY, 7),
            MonthDay.of(Month.JANUARY, 8),
            MonthDay.of(Month.FEBRUARY, 14),
            MonthDay.of(Month.MARCH, 1),
            MonthDay.of(Month.MARCH, 8),
            MonthDay.of(Month.MAY, 1),
            MonthDay.of(Month.MAY, 9),
            MonthDay.of(Month.JUNE, 1),
            MonthDay.of(Month.AUGUST, 27),
            MonthDay.of(Month.AUGUST, 31),
            MonthDay.of(Month.SEPTEMBER, 1),
            MonthDay.of(Month.OCTOBER, 6),
            MonthDay.of(Month.DECEMBER, 25),
            MonthDay.of(Month.DECEMBER, 26)));


    @Override
    public Temporal adjustInto(Temporal temporal) {

        MonthDay currentMonthDay = MonthDay.from(temporal);
        int year = temporal.get(ChronoField.YEAR);

        for (MonthDay monthDay : holidays) {
            if (currentMonthDay.isBefore(monthDay)) {
                return monthDay.atYear(year);
            }
        }
        return holidays.get(0).atYear(year + 1);
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now().with(new NextHoliday()));
    }
}