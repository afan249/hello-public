package com.friend.spider.lnn.CoreJava.chapter04;

import java.time.LocalDate;

/**
 * 雇员实体类
 */
public class Employee {

    /*
     定义为final，说明name不会再被修改，即没有setName方法
    */
    private final String name;
    private double salary;
    // alt + Enter 自动导入import
    private LocalDate hireDay;
    private static int nextId = 1;
    private int id;
    // 对于可变的类，使用final修饰符可能会对读者造成混乱，如下
//    private final StringBuilder evaluations;

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
        - 构造器与类同名
        - 每个类可以有一个以上的构造器
        - 构造器可以有0个、1个或多个参数
        - 构造器没有返回值

        - 构造器总是伴随着new操作一起调用
        - 所有的java对象都是在堆中构造的
         */
    public Employee(String n, double s/*, int year, int month, int day*/){
        this.name = n;
        this.salary = s;
//        this.hireDay = LocalDate.of(year, month, day);
        /*
         在构造器中初始化为
         final关键字只是表示存储在evaluations变量中的对象引用不会再指向其他StringBuilder对象，
         但是evaluations可以更改
         */
//        evaluations = new StringBuilder();
    }

    // getter和setter快捷键 alt+insert
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    public void setId() {
        id = nextId;
        nextId++;
    }
}
