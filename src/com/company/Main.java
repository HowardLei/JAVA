package com.company;

public class Main {

    public static void main(String[] args) {
        doSth();
    }

    public static void doSth() {
        var thread = new Thread(() ->
                System.out.println(123));
        thread.start();
    }
}