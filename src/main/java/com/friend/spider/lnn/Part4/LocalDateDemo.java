package com.friend.spider.lnn.Part4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * 当前年月日
 */
public class LocalDateDemo {

    public static void main(String[] args){

//        LocalDate  localdate = LocalDate.of(2018,12,7);
//
//        int year = localdate.getYear();
//        int month = localdate.getMonthValue();
//        int day = localdate.getDayOfMonth();

        LocalDate date = LocalDate.now();
        // 获取当前月和日
        int dqmonth = date.getMonthValue();
        int dqday = date.getDayOfMonth();
        System.out.println(dqmonth+"---"+dqday);

        // 将date设置为这个月第一天，并得出这天周几
        date = date.minusDays(dqday - 1);
        System.out.println(date);

        DayOfWeek weekday = date.getDayOfWeek();
        System.out.println(weekday);
        System.out.println(weekday.getValue());

    }

}
