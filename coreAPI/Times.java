package coreAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Times {
    LocalDate localDate = LocalDate.now(); //just a date — no time and no time zone. 12.01.1996 for example
    LocalTime localTime = LocalTime.now(); // just a time — no date and no time zone. 12.34 for example
    LocalDateTime localDateTime = LocalDateTime.now(); // Contains both a date and time but no time zone.

    LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
    LocalDate date2 = LocalDate.of(2015, 1, 20); // months behave like real life ones (from 1 to 12)

    LocalTime time1 = LocalTime.of(6, 15); // hour and minute
    LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
    LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

    LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30, 12);
    LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

    // u cannot use constructors
    //LocalDate d = new LocalDate(); // DOES NOT COMPILE
    LocalDate date3 = LocalDate.of(2016, Month.APRIL, 32); // throws DateTimeException at runtime


    //The date and time classes are immutable (operations do not change them but return new result)
{
    localDate = localDate.plusDays(2); // have to save it manually cause the methods do not change the date obj
    localDate = localDate.plusWeeks(1);
    localDate = localDate.plusMonths(1);
    localDate = localDate.plusYears(5);

    localTime = localTime.plusHours(1).plusMinutes(2).plusSeconds(2).plusNanos(34); // ofc alse there are "minus" commands
    localDateTime = localDateTime.minusWeeks(4).minusHours(3); // has methods for both days and times
    // Whenever you see immutable types, pay attention to make sure the return value of a method call isn’t ignored!!

    localDate.isBefore(date3);
    localDate.toEpochDay(); //the number of days since January 1, 1970

    Period period = Period.ofMonths(1); // of.. days, weeks, months, years
    period = Period.of(1, 2, 3);
    // attention!
    Period wrong = Period.ofYears(1).ofWeeks(1); // it is just "ofWeeks(1)"
    localDateTime.plus(period);
    localTime.plus(period);// it will throw runtime ex cause time cant be added to date period

    localDate.getDayOfYear();
    localDate.getDayOfMonth();
    localDate.getDayOfWeek(); // enum- monday, tuesday etc
    localDate.getYear();
    localDate.getMonth(); // enum- january, etc

    localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
    localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    DateTimeFormatter shortDateTime =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); // pay attention - "ofLocalizedDate" means LocalTime class cant be formatted with this instance
    // ofLocalizedDate can be used with date and datetime.
    // ofLocalizedDateTime - only with datetime
    // ofLocalizedTime - with time and datetime

    // other way is to format using "other side":
    shortDateTime.format(localDate); // kind of "1/20/20" - month/day/year - it was SHORT. MEDIUM does smth like "Jan 20, 2020"
    localDate.format(shortDateTime);

    DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm"); // Remember M (uppercase) is month and m (lowercase) is minute. make sure object contains required parts
    System.out.println(localDateTime.format(f)); // January 20, 2020, 11:12

    f = DateTimeFormatter.ofPattern("MM dd yyyy");
    LocalDate date = LocalDate.parse("01 02 2015", f);
    LocalTime time = LocalTime.parse("11:22");
}
}
