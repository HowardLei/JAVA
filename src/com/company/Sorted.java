package com.company;

import java.util.*;

public class Sorted<T extends Number> {
    private T[] numbers;
    public int[] values;
    Sorted(T[] arr) {
        this.numbers = arr;
    }
    public Sorted(int[] values) {
        this.values = values;
    }
    public <T extends Number> void quickSort(int left, int right, int x) {
        if (left < right) {
            var leftPointer = left;
            var rightPointer = right;
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
            quickSort(leftPointer, left - 1);
            quickSort(right + 1, rightPointer);
        } else {
            return;
        }
    }

    /**
     * 正确的快速排序的实现
     * @param left 需要排序数组的左边界
     * @param right 需要排序数组的右边界
     */
    public void quickSort(int left, int right) {
        if (left < right) {
            var leftPoint = left;
            var rightPoint = right;
            var compare = values[left];
            var temp = 0;
            while (leftPoint < rightPoint) {
                while (compare <= values[rightPoint] && leftPoint < rightPoint) {
                    rightPoint--;
                }
                while (compare >= values[leftPoint] && leftPoint < rightPoint) {
                    leftPoint++;
                }
                if (leftPoint < rightPoint) {
                    temp = values[leftPoint];
                    values[leftPoint] = values[rightPoint];
                    values[rightPoint] = temp;
                }
            }
            values[left] = values[leftPoint];
            values[leftPoint] = compare;
            quickSort(left, leftPoint - 1);
            quickSort(rightPoint + 1, right);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        var temp = nums.length;
        var t = nums[0];
        for (var i = 1; i < temp; ) {
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
     *
     * @param nums 需要筛选的数组
     * @return 唯一出现的数字
     */
    public static int singleNumber(int[] nums) {
        for (var i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    /**
     * 两个数组的交集 II
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 所得的交集数组
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        var map1 = init(nums1);
        var map2 = init(nums2);
        var list = new ArrayList<Integer>();
        map1.forEach((Integer key, Integer value) -> {
            if (map2.containsKey(key)) {
                for (var i = 0; i < Math.min(value, map2.get(key)); i++) {
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
     *
     * @param nums 需要转化的数组
     * @return 转化成功的字典
     */
    private static HashMap<Integer, Integer> init(int[] nums) {
        var map = new HashMap<Integer, Integer>(nums.length);
        for (var i : nums) {
            if (map.containsKey(i)) {
                var value = map.get(i);
                map.put(i, ++value);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>(nums.length);
        var key = 0;
        var values = new int[2];
        for (var i = 0; i < nums.length; i++) {
            key = target - nums[i];
            if (map.containsKey(key)) {
                var iter = map.values().iterator();
                key = 0;
                while (iter.hasNext()) {
                    values[key++] = iter.next();
                }
                return values;
            } else {
                map.put(key, i);
            }
        }
        return null;
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * @param digits 需要加 1 的数组
     * @return 加 1 完成的数组
     */
    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        var stack = new Stack<Integer>();
        for (var digit : digits) {
            stack.add(digit);
        }
        var iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        return null;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 原数组
     */
    public static void moveZeroes(int[] nums) {
        var list = new ArrayList<Integer>(nums.length);
        var iter = list.iterator();
        iter.forEachRemaining((Integer integer) -> {
            list.add(integer);
        });
        for (var i : nums) {
            if (i != 0) {
                list.add(i);
            }
        }
        var newNums = new int[nums.length];
        for (var i = 0; i < newNums.length; i++) {
            nums[i] = iter.hasNext() ? iter.next() : 0;
        }
        nums = newNums;
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * @param s 需要查找的字符串
     * @return 第一个不重复字符的索引，如果没有该索引，则返回 -1
     */
    public static int firstUniqChar(String s) {
        var map = new HashMap<Character, Boolean>(s.length());
        var c = s.toCharArray();
        for (var i = 0; i < s.length(); i++) {
            map.put(c[i], map.containsKey(c[i]));
        }
        for (var i = 0; i < s.length(); i++) {
            if (!map.get(c[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个字符串，验证它是否是回文串。
     * 标准：只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * @param s 需要检查的字符串
     * @return 是否符合标准
     */
    public static boolean isPalindrome(String s) {
        // 先判断这个串是否为空，如果为空返回为真串，否则继续判断。
        if (s.equals(null) || ("").equals(s)) {
            return true;
        }
        var charArray = s.toLowerCase().toCharArray();
        // 创建左右双指针。记录判断字符的位置。
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            if (Character.isLetterOrDigit(charArray[left])) {
                if (Character.isLetterOrDigit(charArray[right])) {
                    if (charArray[left++] != charArray[right--]) {
                        return false;
                    }
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] values = {2, 4, 51, 7, 9, 3, 10, 8, 34, 6, 9, 12};
        var sorted = new Sorted<>(values);
        sorted.quickSort(0, values.length - 1);
        for (int value : values) {
            System.out.println(value);
        }
    }
}