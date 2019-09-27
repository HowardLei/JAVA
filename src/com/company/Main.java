package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var length = input.nextInt();
        var len = 0;
        var demo1s = new Demo1[length];
        var time = new int[length];
        var allTime = 0;
        var sortedDemo1s = new Demo1[length];
        for (var i = 0; i < length; i++) {
            var a = input.nextInt();
            var t = input.nextInt();
            demo1s[i] = new Demo1(a, t);
            time[i] = a * t;
            len += (0.5 * a * t * t);
            allTime += t;
        }
        for (var i = 0; i < length; i++) {
        }
    }
}

class Demo1 {
    public int a;
    public int b;
    Demo1(int a, int b) {
        this.a = a;
        this.b = b;
    }
}