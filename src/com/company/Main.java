package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Welcome to Java");
        }
        String[] allJLines = {"    J", "    J", "J   J", " J J "};
        String[] allALines = {"   A   ", "  A A  ", " AAAAA ", "A     A"};
        String[] allVLines = {"V     V", " V   V ", "  V V  ", "   V   "};
        for (int i = 0; i < 4; i++) {
            String a = allJLines[i] + " " + allALines[i] + " " + allVLines[i] + " " + allALines[i];
            System.out.println(a);
        }
        int res = 0;
        for (int i = 1; i < 10; i++) {
            res += i;
        }
        System.out.println(res);
    }
}