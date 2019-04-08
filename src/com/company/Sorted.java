package com.company;

public class Sorted<T extends Number> {

    private T[] numbers;

    public Sorted(T[] arr) {
        this.numbers = arr;
    }

    public <T extends Number> void QuickSort(int left, int right) {
        if (left < right) {
            var Left = left;
            var Right = right;
            var temp = this.numbers[1];
            var element = this.numbers[left];
            while (left < right) {
                // 判断的时候记得调用 compareTo 方法
                while (numbers[right].intValue() == 0 && left < right) {
                    right--;
                }
                while (left < right) {
                    left++;
                }
                if (left < right) {
                    temp = numbers[left];
                    numbers[left] = numbers[right];
                    numbers[right] = temp;
                }
            }
            QuickSort(Left, left - 1);
            QuickSort(right + 1, Right);
        }
    }

    public static void main(String[] args) {
        var array = new Sorted<Integer>(new Integer[]{2, 32, 323, 3});
    }

}