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
                // FIXME: 判断的逻辑并不完善，需要判断各个类的数据
                while (numbers[right].doubleValue() > element.doubleValue() && left < right) {
                    right--;
                }
                while (left < right && numbers[left].doubleValue() < element.doubleValue()) {
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
        var numbers = new Integer[]{2, 32, 323, 3};
        var array = new Sorted<Integer>(numbers);
        array.QuickSort(0, numbers.length - 1);
        for (var integer : numbers) {
            System.out.println(integer);
        }
    }
}