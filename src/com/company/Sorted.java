package com.company;

import java.util.*;

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
    /**
     * 只出现一次的数字
     * @param nums 需要筛选的数组
     * @return 唯一出现的数字
     * */
    public static int singleNumber(int[] nums) {
        for (var i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
    /**
     * 两个数组的交集 II
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 所得的交集数组
     * */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> table1 = init(nums1);
        var list = new ArrayList<Integer>();
        Hashtable<Integer, Integer> table2 = init(nums2);
        table1.forEach((Integer key, Integer value) -> {
            if (table2.containsKey(key)) {
                for (var i = 0; i < Math.min(value, table2.get(key)); i++) {
                    list.add(key);
                }
            }
        });
        var values = new int[list.size()];
        for (var i = 0; i < values.length; i++) {
            values[i] = list.get(i);
        }
        return values;
    }
    /**
     * 将数组当中的元素转化为 <数组元素:在数组中出现次数> 的字典
     * @param nums 需要转化的数组
     * @return 转化成功的字典
     * */
    private static Hashtable<Integer, Integer> init(int[] nums) {
        var table = new Hashtable<Integer, Integer>();
        for (int i : nums) {
            if (table.containsKey(i)) {
                var value = table.get(i);
                table.put(i, ++value);
            } else {
                table.put(i, 1);
            }
        }
        return table;
    }

    public static void main(String[] args)  {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 3);
        System.out.println(map);
        map.replace(2, 4);
        System.out.println(map);
    }
}