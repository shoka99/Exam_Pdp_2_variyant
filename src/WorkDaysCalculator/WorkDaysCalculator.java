package WorkDaysCalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkDaysCalculator {
    public static void main(String[] args) {
        LocalDate beginDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 1);

        int totalHours = 0;

        while (endDate.isAfter(beginDate)) {
            if (beginDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                totalHours += 8;
            }
            if (beginDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalHours += 4;
            }
            beginDate = beginDate.plusDays(1);
        }
        System.out.println("totalHours = " + totalHours);
    }
}
