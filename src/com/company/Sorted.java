package com.company;

public class Sorted<T>{

    public static <T> void QuickSort(T[] values) {
        var left = 0;
        var right = values.length - 1;
        if (left < right) {
            var value = partion(values);
        }
    }

    public static <T> T partion(T[] values) {
        return null;
    }
}
