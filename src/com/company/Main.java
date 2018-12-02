package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Complex number = new Complex("2+3i");
            Complex number1 = new Complex("avsa+2");
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
    }
}