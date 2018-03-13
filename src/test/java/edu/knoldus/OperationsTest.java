package edu.knoldus;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by pallavi on 13/3/18.
 */
public class OperationsTest {
    private static Operations operations;

    @BeforeClass public static void setUp() {
        operations = new Operations();
    }

    @Test public void getBirthDates() {
        List<DayOfWeek> list = new ArrayList<>();
        List<DayOfWeek> expectedList =
                Arrays.asList(THURSDAY, SATURDAY, SUNDAY, MONDAY, TUESDAY, THURSDAY, FRIDAY,
                        SATURDAY, SUNDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUNDAY, MONDAY,
                        TUESDAY, WEDNESDAY, FRIDAY, SATURDAY, SUNDAY, MONDAY, WEDNESDAY, THURSDAY,
                        FRIDAY, SATURDAY, MONDAY);
        list = Operations.getBirthDates(1992, 1, 23, list);
        assertEquals("getBirthDates", expectedList, list);

    }

    @Test public void getTimeFromTimeZone() {
         LocalDateTime date = LocalDateTime.now();
         ZoneId zone = ZoneId.of("Asia/Kabul");
         ZonedDateTime zdt = date.atZone(zone);
         ZoneOffset offset = zdt.getOffset();

        String timeFromTimeZone = Operations.getTimeFromTimeZone("Asia/Kabul");
        String expectedResult = date + " " + offset;
        assertEquals("getTimeFromTimeZone", expectedResult, timeFromTimeZone);

    }


    @Test public void numberOfSecondsGandhiLived() {
        long actualResult = Operations.numberOfSecondsGandhiLived();
        long expectedResult = 2474323200L;
        assertEquals("numberOfSecondsGandhiLived", expectedResult, actualResult);

    }

    @Test public void findLeapYears() {
        List<Integer> leapYears = Operations.findLeapYears();
        int[] arr = { 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952,
                1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008,
                2012, 2016 };
        List<Integer> expectedResult = Arrays.stream(arr).boxed().collect(Collectors.toList());
        assertEquals("findLeapYears", expectedResult, leapYears);
    }

}
