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
 * 15. 三数之和
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。



 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
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

            // conitue 比 while直观，上面的while要判断两个边界
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 跳过不可能
            if (nums[i] > 0) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    // 快速创建List
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    // 去重，判断越界
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                    // 去重，判断越界
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