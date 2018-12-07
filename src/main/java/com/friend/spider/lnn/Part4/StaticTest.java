package com.friend.spider.lnn.Part4;

public class StaticTest {

    public static void main(String[] args){

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("lnn", 25000);
        staff[1] = new Employee("wpp", 23000);
        staff[2] = new Employee("lxn", 25000);

        for(Employee e : staff){
            e.setId();
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
        }

        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);

    }

}
