package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        var input = in.next().toUpperCase();
        var size = Enum.valueOf(Size.class, input);
        System.out.println("size = " + size);
        System.out.println("size.getAbbreviation() = " + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}