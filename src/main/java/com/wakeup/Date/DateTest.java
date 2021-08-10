package com.wakeup.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.FixedDateTimeZone;

import java.util.Date;
import java.util.HashMap;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DateTest {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);

        DateTime dateTime = new DateTime(date);
        System.out.println(dateTime);
        System.out.println(dateTime.getZone());
        System.out.println(dateTime.toDate());

        System.out.println("==========================================");
        TimeZone timeZone = new SimpleTimeZone(1, "America/New_York");
        DateTime dateTime1 = new DateTime(FixedDateTimeZone.forTimeZone(timeZone));
        System.out.println(dateTime1);

        DateTime dateTime2 = new DateTime(0l);
        System.out.println(dateTime2);

    }
}