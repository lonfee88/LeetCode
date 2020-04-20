/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package sort;

import java.util.Arrays;

/**
 * @author longfei.wlf
 * @version $Id: QuickSort.java, v 0.1 2020-04-20 10:42 AM longfei.wlf Exp $$
 */
public class QuickSort {

    // [left,right]
    private int partition(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] > temp) {
                right--;
            }
            if (left < right) {
                a[left] = a[right];
            }

            while (left < right && a[left] < temp) {
                left++;
            }
            if (left < right) {
                a[right] = a[left];
            }
        }
        a[left] = temp;
        return left;
    }

    public void sort(int[] a, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(a, left, right);
            // 递归调用sort，而不是partition
            sort(a, left, dp - 1);
            sort(a, dp + 1, right);
        }
    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 9, 1, 7, 6, 2, 3, 8 };
        new QuickSort().sort(a, 0, 8);
        System.out.println(Arrays.toString(a));
    }
}