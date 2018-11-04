package com.company;

import Book.Mydate;
import Book.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("王尼玛", new Mydate(2000, 2, 29), "male", "北京", "北京", 18);
        Person person1 = new Person(person);
        boolean a = person.equals(person1);
        System.out.println(person);
        System.out.println(person1);
        System.out.println(Person.showCount());
        System.out.println(a);
    }
}