/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * 15. ����֮��
 ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣

 ע�⣺���в����԰����ظ�����Ԫ�顣



 ʾ����

 �������� nums = [-1, 0, 1, 2, -1, -4]��

 ����Ҫ�����Ԫ�鼯��Ϊ��
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 *
 * https://leetcode-cn.com/problems/3sum/solution/javashi-pin-jiang-jie-xi-lie-3-sum-by-sean-kuang/
 *
 *
 * @author longfei.wlf
 * @version $Id: ThreeSum.java, v 0.1 2020-05-22 9:48 PM longfei.wlf Exp $$
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // while(i < n - 1 && i > 0 && nums[i] == nums[i - 1]){
            //     i++;
            // }

            // conitue �� whileֱ�ۣ������whileҪ�ж������߽�
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ����������
            if (nums[i] > 0) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    // ���ٴ���List
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    // ȥ�أ��ж�Խ��
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                    // ȥ�أ��ж�Խ��
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

}