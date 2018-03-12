package edu.knoldus;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pallavi on 10/3/18.
 */
public class Operations {
    public static List<DayOfWeek> getBirthDates(int year, int month, int day,
            List<DayOfWeek> list) {
        LocalDate bday = LocalDate.of(year, month, day);
        int getYear = bday.getYear();
        if (getYear < 2018) {
            DayOfWeek getDay = bday.getDayOfWeek();
            list.add(getDay);
            getBirthDates(year + 1, month, day, list);
        } else {
            return list;
        }
        return list;
    }

    public static void getTimeFromTimeZone(String timeZone) {

        LocalDateTime date = LocalDateTime.now();
        ZoneId zone = ZoneId.of(timeZone);
        ZonedDateTime zdt = date.atZone(zone);
        ZoneOffset offset = zdt.getOffset();
        System.out.println(date + " " + offset);

        // LocalDateTime date = LocalDateTime.now().atZone(ZoneId.of(timeZone)).toLocalDateTime();
        //System.out.println(date);

    }

    public static long numberOfSecondsGandhiLived() {
        LocalDateTime d = LocalDateTime.of(1869, 9, 2, 0, 0);
        LocalDateTime d2 = LocalDateTime.of(1948, 1, 30, 0, 0);
        return Duration.between(d, d2).toMinutes() * 60;

    }

    public static List<Integer> findLeapYears() {
        LocalDate date = LocalDate.of(1900, 1, 1);

        List<Integer> list = new ArrayList<>();
        int year = date.getYear();
        while (year != 2019) {
            if (date.isLeapYear()) {
                list.add(year);
            }
            year = year + 1;
            date = LocalDate.of(year, 1, 1);

        }
        return list;
    }
}
