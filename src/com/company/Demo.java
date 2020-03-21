package com.company;

import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Demo class
 *
 * @author apple
 * @date 2019-08-21
 */
public class Demo {
    public static void main(String[] args) {
        var linkedList = new LinkedList<Integer>();
        linkedList.add(12);
        linkedList.add(22);
        var iterator = linkedList.iterator();
        var next = iterator.next();
        var integerListIterator = linkedList.listIterator();
        integerListIterator.next();
        integerListIterator.set(321);
        System.out.println(iterator.next());
        Consumer<? extends Number> consumer = (Number number) -> {

        };
    }
}