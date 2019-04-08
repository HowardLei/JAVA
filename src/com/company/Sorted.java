package com.company;

public class Sorted<T extends Number> {

    private T[] numbers;

    public Sorted(T[] arr) {
        this.numbers = arr;
    }

    public static <T> void QuickSort(T[] value, int left, int right) {
        if (left < right) {
            var Left = left;
            var Right = right;
            var temp = value[1];
            var element = value[left];
            while (left < right) {
                // 判断的时候记得调用 compareTo 方法
                while (value[right] && left < right) {
                    right--;
                }
                while (left < right &&) {
                    left++;
                }
                if (left < right) {
                    temp = value[left];
                    value[left] = value[right];
                    value[right] = temp;
                }
            }
            QuickSort(value, Left, left - 1);
            QuickSort(value, right + 1, Right);
        }
    }

    public static void main(String[] args) {
        var array = new Sorted<Integer>(new Integer[]{2, 32, 323, 3});
    }

}