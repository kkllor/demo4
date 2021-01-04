package com.learn;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kkllor
 * @date 2020/12/28 2:13 PM
 */
public class TestFileSize {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = simpleDateFormat.parse("13:23").getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 23);
        System.out.println(simpleDateFormat1.format(calendar.getTime()));
    }
}
