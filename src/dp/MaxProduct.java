/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

/**
 *
 * 152. 乘积最大子数组
 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



 示例 1:

 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。
 示例 2:

 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


 https://leetcode-cn.com/problems/maximum-product-subarray/

 * @author longfei.wlf
 * @version $Id: MaxProduct.java, v 0.1 2020-05-18 4:47 PM longfei.wlf Exp $$
 */
public class MaxProduct {

    /**
     *
     * 不用判断正负，直接比较最值即可
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int preMax = 1, preMin = 1;
        for (int num : nums) {
            int max = Math.max(num, Math.max(preMax * num, preMin * num));
            int min = Math.min(num, Math.min(preMax * num, preMin * num));
            result = Math.max(result, max);
            preMin = min;
            preMax = max;
        }
        return result;
    }

    /**
     *
     * 解题思路
     分析可知, 在没有0的情况下, 最大子数组一定是从一端开始的
     证明:
        如果两边其他部分的乘积符号相同的话, 那么可以延伸到整个数组
        如果乘积符号不同的话, 总可以延伸到正的乘积的部分的端点处
        如果遇到0的话, 就隔开重新计算新的前后缀即可(相当于新的一段的数组)
     注意初始化前后缀都是0, 表示新的一段数组的开始, 如果前后缀都是0的话直接更新为当前元素的值
     时间O(N), 空间O(1)
     代码
     class Solution:
     def maxProduct(self, nums: List[int]) -> int:
     prefix, suffix, res = 0, 0, -float('inf')
     for i in range(len(nums)):
     prefix = nums[i] if not prefix else nums[i]*prefix
     suffix = nums[-i - 1] if not suffix else nums[-i - 1]*suffix
     res = max(res, prefix, suffix)
     return res
     大家可以在下面这些地方找到我~?

     作者：suibianfahui
     链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/ti-gong-yi-chong-ondan-bu-shi-dong-tai-gui-hua-de-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int prefix = 0;
        int suffix = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (prefix == 0) {
                prefix = nums[i];
            } else {
                prefix *= nums[i];
            }

            if (suffix == 0) {
                suffix = nums[len - i - 1];
            } else {
                suffix *= nums[len - i - 1];
            }
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

    /**
     *
     * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     *
     * @param nums
     * @return
     */
    public int maxProduct3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int ans = nums[0];
        int min = 1;
        int max = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}