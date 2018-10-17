package com.company;

public class Person {
    private int age;
    private String name;
    private boolean sex;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    // 重载 Person 方法
    Person(int age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    Person(Person p1){
        this(p1.age, p1.name, p1.sex);
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isBoy() {
        return this.sex;
    }
}
