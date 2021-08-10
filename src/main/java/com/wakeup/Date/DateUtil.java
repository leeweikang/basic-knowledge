package com.wakeup.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.FixedDateTimeZone;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    public static void main(String[] args) {

        String timeZone = "Asia/Tokyo";
        Date date1 = new Date();

        Date time = new Date();
        DateTime dateTime = new DateTime(time, DateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZone)));
        DateTime dateTime1 = new DateTime(time, DateTimeZone.getDefault());
        System.out.println(dateTime);
        System.out.println(dateTime1);

        System.out.println(time);

        Date endTime = new DateTime(new Date(), DateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZone))).plusHours(3).toDate();
        System.out.println(endTime);

//        String timeZone = "Asia/Tokyo";
//        ZoneId zoneId1 = ZoneId.systemDefault();
//        ZoneId zoneId2 = ZoneId.of(timeZone);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("localDateTime:   "+localDateTime);
//        ZonedDateTime zdt1 = localDateTime.atZone(zoneId1);
//        ZonedDateTime zdt2 = localDateTime.atZone(zoneId2);
//        System.out.println("localDateTime2Date:  "+Date.from(zdt1.toInstant()));
//        System.out.println("localDateTime2Date:  "+Date.from(zdt2.toInstant()));
//
//        ZonedDateTime paris = ZonedDateTime.now(ZoneId.of("Europe/Paris")); // 欧洲巴黎 +1 时区
//        ZonedDateTime shanghai = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")); // 亚洲上海 +8 时区
//        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo")); // 欧洲巴黎 +9 时区
//        System.out.println(paris);
//        System.out.println(shanghai);
//        System.out.println(tokyo);
//        System.out.println(Date.from(paris.toInstant()));
//        System.out.println(Date.from(shanghai.toInstant()));
//        System.out.println(Date.from(tokyo.toInstant()));
    }

    public static Date getCurrentTime(String timeZone){
        if (timeZone == null) {
            timeZone = "Asia/Shanghai";//获取指定时区的时间
        }
        DateTime dateTime = new DateTime();
        return dateTime.toDateTime(FixedDateTimeZone.forTimeZone(TimeZone.getTimeZone(timeZone))).toDate();
    }

}
