package com.friend.spider.lnn.Part4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 输出当月日历
 */
public class CalendarTest {

    /*
    调试快捷键
    F9            resume programe 恢复程序
    Alt+F10       show execution point 显示执行断点
    F8            Step Over 相当于eclipse的f6      跳到下一步
    F7            Step Into 相当于eclipse的f5就是  进入到代码
    Alt+shift+F7  Force Step Into 这个是强制进入代码
    Shift+F8      Step Out  相当于eclipse的f8跳到下一个断点，也相当于eclipse的f7跳出函数
    Atl+F9        Run To Cursor 运行到光标处
    ctrl+shift+F9   debug运行java类
    ctrl+shift+F10  正常运行java类
    alt+F8          debug时选中查看值
     */
    public static void main(String[] args){

        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 设置今天为月初第一天
        date = date.minusDays(today - 1);
        // date为周几
        DayOfWeek weekday = date.getDayOfWeek();
        // 1 = Monday，... 7 = Sunday
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }

        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
