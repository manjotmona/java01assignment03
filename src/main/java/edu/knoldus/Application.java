package edu.knoldus;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pallavi on 10/3/18.
 */
public class Application {

    public static void main(String[] args) {

        List<DayOfWeek> list = new ArrayList<>();
        System.out.println(Operations.getBirthDates(1992, 1, 23, list));
        System.out.println(Operations.getTimeFromTimeZone("Asia/Kabul"));
        System.out.println(Operations.findLeapYears());

        System.out.println(Operations.numberOfSecondsGandhiLived());

    }

}
