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
            // 注意要取等号，否则当全部待排序数字都相同的时候会死循环！
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            // pay attention to the equal, otherwise it will get into endless loop!
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
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
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}