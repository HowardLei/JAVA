package com.company;

/**
 * ReflectClass class
 *
 * @author apple
 * @date 2019-08-19
 */
public class ReflectClass {
    public static void main(String[] args) {
        // 1. 如何获得 Java 当中的类对象？
        // 1.1 通过 类名.class 获得
        Class<? extends ReflectClass> aClass = ReflectClass.class;
        // 1.2 通过 Class.forName(全限定名) 方法获得
        // 1.3 通过对象当中的 getClass 方法获得
        var reflect = new ReflectClass();
        aClass = reflect.getClass();
        Double[].class.getName();
    }
}
