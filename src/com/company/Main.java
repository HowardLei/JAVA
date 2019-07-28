package com.company;

public class Main {

    public static void main(String[] args) {
        var values = new int[]{2, 3, 5, 4, 8};
        var value = 0;
        for (var i = 0; i < values.length - 1; i++) {
            for (var j = 1; j < values.length; j++) {
                if (values[i] > values[j]) {
                    value = values[i];
                    values[i] = values[j];
                    values[j] = value;
                }
            }
        }
        for (var i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}