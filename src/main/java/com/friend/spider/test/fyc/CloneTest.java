package com.friend.spider.test.fyc;

public class CloneTest {

    public static void main(String[] args){
        Person oldPerson = new Person(24,"DDDD");
        Person newPerson = null;
        try {
            newPerson = (Person)oldPerson.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        newPerson.setName("wwww");
        System.out.println(oldPerson);
        System.out.println(newPerson);
    }
}

class Person implements Cloneable{

    private int age ;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}

