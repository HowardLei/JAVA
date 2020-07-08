package com.company;

/**
 * Solution class
 *
 * @author apple
 * @date 2019-07-25
 */
public class Solution {
    public static int maxScoreSightseeingPair(int[] A) {
        if (isEmpty(A)) {
            return 0;
        } else {
            if (A.length == 1) {
                return A[0];
            } else {
                var max1 = A[0];
                var max2 = A[1] - 1;
                for (int i = 1; i < A.length - 1; i++) {
                    max1 = Math.max(A[i] + i, max1);
                    max2 = Math.max(A[i + 1] - i - 1, max2);
                }
                return max1 + max2;
            }
        }
    }

    private static boolean isEmpty(int[] a) {
        return a == null || a.length == 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2};
        System.out.println(maxScoreSightseeingPair(a));
    }
}