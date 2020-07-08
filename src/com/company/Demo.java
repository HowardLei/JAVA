package com.company;

/**
 * Demo class
 *
 * @author apple
 * @date 2019-08-21
 */
public class Demo {
    private static volatile int i;


    public static void main(String[] args) {
        var t1 = new Thread(Demo::add1);
        var t2 = new Thread(Demo::add2);
        t1.start();
        t2.start();
    }

    /**
     * 该方法是一个
     */
    private static void add1() {
        System.out.println("add1");
        i += 100;
        System.out.println(i);
    }

    /**
     * 该方法是一定会触发锁消除吗？
     */
    private static void add2() {
        System.out.println("add2");
        i += 100;
        System.out.println(i);
    }

    // n:94565384 - 63789581
    // m:94623886 - 63671013
    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
}