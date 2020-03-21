package com.dynamicDelegate;

/**
 * JavaDeveloper class
 *
 * @author apple
 * @date 2020/1/25
 */
public class JavaDeveloper implements Developer {
    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println("Java developer's coding");
    }

    @Override
    public void debug() {
        System.out.println("Java developer's debugging");
    }
}
