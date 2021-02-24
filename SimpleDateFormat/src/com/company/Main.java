package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        TimeZone tz;
        String a;

        /*SimpleDateFormat simpleMonth = new SimpleDateFormat("M");
        SimpleDateFormat simpleDay = new SimpleDateFormat("d");*/

        //System.out.println(date);
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS (z Z)");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        tz = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(tz);
        //System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));

        a = df.format(date);
        System.out.println(a);
        System.out.println(a.substring(0, a.length()-4));
        //System.out.println(tz);
        System.out.println("-------------------");

        /*tz = TimeZone.getTimeZone("Greenwich");
        df.setTimeZone(tz);
        System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
        System.out.println(tz);
        System.out.println("-------------------");

        tz = TimeZone.getTimeZone("America/Los_Angeles");
        df.setTimeZone(tz);
        System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
        System.out.println(tz);
        System.out.println("-------------------");

        tz = TimeZone.getTimeZone("America/New_York");
        df.setTimeZone(tz);
        System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
        System.out.println(tz);
        System.out.println("-------------------");

        tz = TimeZone.getTimeZone("Pacific/Honolulu");
        df.setTimeZone(tz);
        System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
        System.out.println(tz);
        System.out.println("-------------------");

        tz = TimeZone.getTimeZone("Asia/Shanghai");
        df.setTimeZone(tz);
        System.out.format("%s%n%s%n%n", tz.getDisplayName(), df.format(date));
        System.out.println(tz);
        System.out.println("-------------------");


        tz = TimeZone.getTimeZone("UTC");
        df.setTimeZone(tz);
        System.out.println(tz.getDisplayName());
        System.out.println(df.format(date).trim());
        System.out.println("-------------------");

        System.out.println(date.toString());*/

        /*System.out.println(simpleMonth.format(today));
        System.out.println(simpleDay.format(today));*/
    }
}
