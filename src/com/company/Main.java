package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println(0.5 / 0 == Double.POSITIVE_INFINITY);
        System.out.println(Math.round(0.5 / 0));
    }
}

class Demo1 implements Comparable<Demo1> {
    public int a;
    public int b;

    Demo1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Demo1 o) {
        return 0;
    }
}