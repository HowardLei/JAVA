package com.company;

public class Sorted<T extends Number> {
    private T[] numbers;

    Sorted(T[] arr) {
        this.numbers = arr;
    }

    public <T extends Number> void QuickSort(int left, int right) {
        if (left < right) {
            var Left = left;
            var Right = right;
            var temp = this.numbers[1];
            var element = this.numbers[left];
            while (left < right) {
                // FIXME: 判断的逻辑并不完善，需要判断各个类的数据。这个地方应该判断各个类的数据类型再进行决定
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

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int temp = nums.length;
        int t = nums[0];
        for (int i = 1; i < temp;) {
            if (t == nums[i]) {
                temp--;
                for (int s = i; s <= temp - 1; s++) {
                    nums[s] = nums[s + 1];
                }
            } else {
                t = nums[i];
                i++;
            }

        }
        return temp;
    }
    public static void main(String[] args)  {
//        var demo = new Integer[]{2, 32, 323, 3, 234, 342, 4};
//        var array = new Sorted(demo);
//        for (Integer integer : demo) {
//            System.out.println(integer);
//        }
//        System.out.println("------");
//        array.QuickSort(0, demo.length - 1);
//        for (var number : demo) {
//            System.out.println(number);
//        }
        var value = new int[]{0,1};
        var res = removeDuplicates(value);
        for (int i = 0; i < res; i++) {
            System.out.println("value[" + i + "] = " + value[i]);
        }
    }
}