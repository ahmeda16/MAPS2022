import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoUnit;

//COMPLETE
public class ParentGap 
{
    public static void main (String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        long days = difference(mothersDay(year), fathersDay(year));
        long weeks =  days / 7;

        System.out.println(weeks + " weeks");
    }

    public static LocalDate mothersDay(int year)
    {
        YearMonth ym = YearMonth.of(year, Month.MAY);
        LocalDate d3 = ym.atDay(1).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
        return d3;
    }

    public static LocalDate fathersDay(int year)
    {
        YearMonth ym = YearMonth.of(year, Month.JUNE);
        LocalDate d3 = ym.atDay(1).with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));
        return d3;
    }

    public static long difference(LocalDate mothersDay, LocalDate fathersDay)
    {
        long difference = ChronoUnit.DAYS.between(mothersDay, fathersDay);
        return difference;
    }

}
