package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Welcome to Java");
        }
        String[] allJLines = {"    J", "    J", "J   J", " J J "};
        String[] allALines = {"   A   ", "  A A  ", " AAAAA ", "A     A"};
        String[] allVLines = {"V     V", " V   V ", "  V V  ", "   V   "};
        for (int i = 0; i < allALines.length; i++) {
            String a = allJLines[i] + " " + allALines[i] + " " + allVLines[i] + " " + allALines[i];
            System.out.println(a);
        }
        Person p1 = new Person(2, "王尼玛", true);
        Person p2 = new Person(p1.getAge(), p1.getName(), p1.isBoy());
        CompareOperator.demo();
    }
    public static void Josepic() {
//        1、
    }
}