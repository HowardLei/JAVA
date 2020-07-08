package com.company;

import java.util.Arrays;

/**
 * Sort class
 *
 * @author apple
 * @date 2020/6/15
 */
public class Sort {
    private int[] array;

    public Sort(int[] array) {
        this.array = array;
    }

    /**
     * 快排
     *
     * @param left  左游标
     * @param right 右游标
     */
    public void quickSort(int left, int right) {
        if (left < right) {
            var leftPoint = left;
            var rightPoint = right;
            var compare = array[left];
            var temp = 0;
            while (leftPoint < rightPoint) {
                while (compare <= array[rightPoint] && leftPoint < rightPoint) {
                    rightPoint--;
                }
                while (compare >= array[leftPoint] && leftPoint < rightPoint) {
                    leftPoint++;
                }
                if (leftPoint < rightPoint) {
                    temp = array[leftPoint];
                    array[leftPoint] = array[rightPoint];
                    array[rightPoint] = temp;
                }
            }
            array[left] = array[leftPoint];
            array[leftPoint] = compare;
            quickSort(left, leftPoint - 1);
            quickSort(rightPoint + 1, right);
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort() {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public void chooseSort() {
        int i, j, index;
        for (i = 0; i < array.length; i++) {
            index = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    // 其他排序真的忘了……

    @Override
    public String toString() {
        return "Sort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
