/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package search;

/**
 *
 * 4. 寻找两个正序数组的中位数
 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。



 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5
 
 * @author longfei.wlf
 * @version $Id: FindMedianSortedArrays.java, v 0.1 2020-05-21 12:38 AM longfei.wlf Exp $$
 */
public class FindMedianSortedArrays {

    /**
     *
     * [LeetCode刷题] 4. Median of Two Sorted Arrays
     * 
     * 时间复杂度log(m+n)
     *
     * https://www.bilibili.com/video/BV14J411V7VZ/?spm_id_from=333.788.videocard.0
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        // 奇数
        if ((n & 1) == 1) {
            return helper(nums1, nums2, 0, 0, n / 2 + 1);
        }
        // 偶数
        else {
            return (helper(nums1, nums2, 0, 0, n / 2) + helper(nums1, nums2, 0, 0, n / 2 + 1)) / 2.0f;
        }
    }

    /**
     *
     *  查找第K个数
     *
     * @param nums1
     * @param nums2
     * @param start1
     * @param start2
     * @param k 从1开始
     * @return
     */
    private int helper(int[] nums1, int[] nums2, int start1, int start2, int k) {
        System.out.println(start1 + ", " + start2 + ", " + k);
        // 边界判断
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        // 边界判断
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        // base case
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 边界判断，half至少是1
        int half = Math.min(k / 2, Math.min(nums1.length - start1, nums2.length - start2));
        // half至少是1，所以这里-1，左边界为start
        if (nums1[start1 + half - 1] < nums2[start2 + half - 1]) {
            // half 至少是1，所以至少前进1
            return helper(nums1, nums2, start1 + half, start2, k - half);
        } else {
            // half 至少是1，所以至少前进1
            return helper(nums1, nums2, start1, start2 + half, k - half);
        }
    }
}