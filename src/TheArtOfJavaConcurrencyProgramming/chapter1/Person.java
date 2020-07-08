package TheArtOfJavaConcurrencyProgramming.chapter1;

import org.openjdk.jol.info.ClassLayout;

/**
 * Person class
 *
 * @author apple
 * @date 2020/7/5
 */

public class Person {
    private String name;
    private int age;
    private Person son;

    public synchronized void run1() {
        System.out.println("开始执行方法1");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是方法1");
    }

    public synchronized void run2() {
        System.out.println("开始执行方法2");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是方法2");
    }

    public static synchronized void run3() {
        System.out.println("开始执行方法3");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是方法3");
    }

    public static synchronized void run4() {
        System.out.println("开始执行方法4");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是方法4");
    }
}
