package com.company;

public class Person extends Object{
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
//    Person() {
//        this.setAge(0);
//        this.setName("王尼玛");
//        this.setSex(true);
//    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String isBoy() {
        if (this.sex == true) {
            return this.getName() + " is a boy.";
        } else {
            return this.getName() + " is a girl.";
        }
    }

    @Override
    public String toString() {
        return "我叫" + this.getName() + ",今年" + this.age + "岁了。";
    }
}
