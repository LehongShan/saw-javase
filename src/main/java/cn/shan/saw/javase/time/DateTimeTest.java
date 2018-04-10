package cn.shan.saw.javase.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 * Created by shanlehong on 2017/4/5.
 */
public class DateTimeTest {
    public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testDateTime(){

        calendar();
        localDateTime();

        currentTime();

    }

    @Test
    public void testDateFormat(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        Date date = Calendar.getInstance().getTime();
        System.out.println(simpleDateFormat.format(date));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
        LocalDateTime ld = LocalDateTime.now();
        System.out.println("java8:"+ld.format(dateTimeFormatter));

    }

    @Test
    public void testYesterdayCurrent(){

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusDays(1);
        System.out.println("现在时间为："+localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT)));
        System.out.println("昨天时间为："+localDateTime1.format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT)));


    }


    void calendar(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒");
        Date date = calendar.getTime();
        System.out.println(date);
    }


    void localDateTime(){
        LocalDateTime ld = LocalDateTime.now();
        int year1 = ld.getYear();
        int month1 = ld.getMonthValue();
        int day1 = ld.getDayOfMonth();
        int hour1 = ld.getHour();
        int minute1 = ld.getMinute();
        int second1 = ld.getSecond();
        System.out.println(year1+"年"+month1+"月"+day1+"日"+hour1+"时"+minute1+"分"+second1+"秒");
    }

    void currentTime(){

        long sysMillisTime = System.currentTimeMillis();
        System.out.println("sysMillisTime:"+sysMillisTime);
        long calendarMillisTime =  Calendar.getInstance().getTimeInMillis();
        System.out.println("calendarMillisTime:"+calendarMillisTime);
        long clockMillisTime = Clock.systemDefaultZone().millis();
        System.out.println("clockMillisTime:"+clockMillisTime);

    }
}
