/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package search;

/**
 *
 * 4. Ѱ�����������������λ��
 ����������СΪ m �� n �����򣨴�С�������� nums1 �� nums2��

 �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��

 ����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�



 ʾ�� 1:

 nums1 = [1, 3]
 nums2 = [2]

 ����λ���� 2.0
 ʾ�� 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 ����λ���� (2 + 3)/2 = 2.5
 
 * @author longfei.wlf
 * @version $Id: FindMedianSortedArrays.java, v 0.1 2020-05-21 12:38 AM longfei.wlf Exp $$
 */
public class FindMedianSortedArrays {

    /**
     *
     * [LeetCodeˢ��] 4. Median of Two Sorted Arrays
     * 
     * ʱ�临�Ӷ�log(m+n)
     *
     * https://www.bilibili.com/video/BV14J411V7VZ/?spm_id_from=333.788.videocard.0
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        // ����
        if ((n & 1) == 1) {
            return helper(nums1, nums2, 0, 0, n / 2 + 1);
        }
        // ż��
        else {
            return (helper(nums1, nums2, 0, 0, n / 2) + helper(nums1, nums2, 0, 0, n / 2 + 1)) / 2.0f;
        }
    }

    /**
     *
     *  ���ҵ�K����
     *
     * @param nums1
     * @param nums2
     * @param start1
     * @param start2
     * @param k ��1��ʼ
     * @return
     */
    private int helper(int[] nums1, int[] nums2, int start1, int start2, int k) {
        System.out.println(start1 + ", " + start2 + ", " + k);
        // �߽��ж�
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        // �߽��ж�
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        // base case
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // �߽��жϣ�half������1
        int half = Math.min(k / 2, Math.min(nums1.length - start1, nums2.length - start2));
        // half������1����������-1����߽�Ϊstart
        if (nums1[start1 + half - 1] < nums2[start2 + half - 1]) {
            // half ������1����������ǰ��1
            return helper(nums1, nums2, start1 + half, start2, k - half);
        } else {
            // half ������1����������ǰ��1
            return helper(nums1, nums2, start1, start2 + half, k - half);
        }
    }
}