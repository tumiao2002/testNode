package com.example.needone1.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date getNowDate()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        return date;
    }
}
