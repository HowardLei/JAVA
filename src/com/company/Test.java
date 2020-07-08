package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class
 *
 * @author apple
 * @date 2020/6/15
 */
public class Test {
    private List<String> stringList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();

    {
        stringList.add("123");
        stringList.add("456");
        stringList.add("789");

        var person1 = new Person("123", 43, 0);
        var person2 = new Person("23", 3, 0);
        var person3 = new Person("12", 34, 0);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }

    /**
     * 获得一个新的列表
     *
     * @return 新的列表
     */
    public List<String> getStringList() {
        return new ArrayList<>(this.stringList);
    }

    public List<Person> getPersonList() {
        var people = new ArrayList<>(personList);
        return people;
    }

    public static void main(String[] args) {
        var test = new Test();
        // 在需要操作 stringList 的列表的时候不修改原有 stringList 的时候，需要在方法中传递 test 变量。调用该类的 get 方法即可获得一个与之前完全不一样的列表。
        var personList = test.getPersonList();
        personList.forEach(System.out::println);
    }
}
