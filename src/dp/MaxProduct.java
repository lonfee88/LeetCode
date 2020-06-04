/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

/**
 *
 * 152. �˻����������
 ����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���



 ʾ�� 1:

 ����: [2,3,-2,4]
 ���: 6
 ����: ������ [2,3] �����˻� 6��
 ʾ�� 2:

 ����: [-2,0,-1]
 ���: 0
 ����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣


 https://leetcode-cn.com/problems/maximum-product-subarray/

 * @author longfei.wlf
 * @version $Id: MaxProduct.java, v 0.1 2020-05-18 4:47 PM longfei.wlf Exp $$
 */
public class MaxProduct {

    /**
     *
     * �����ж�������ֱ�ӱȽ���ֵ����
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
     * ����˼·
     ������֪, ��û��0�������, ���������һ���Ǵ�һ�˿�ʼ��
     ֤��:
        ��������������ֵĳ˻�������ͬ�Ļ�, ��ô�������쵽��������
        ����˻����Ų�ͬ�Ļ�, �ܿ������쵽���ĳ˻��Ĳ��ֵĶ˵㴦
        �������0�Ļ�, �͸������¼����µ�ǰ��׺����(�൱���µ�һ�ε�����)
     ע���ʼ��ǰ��׺����0, ��ʾ�µ�һ������Ŀ�ʼ, ���ǰ��׺����0�Ļ�ֱ�Ӹ���Ϊ��ǰԪ�ص�ֵ
     ʱ��O(N), �ռ�O(1)
     ����
     class Solution:
     def maxProduct(self, nums: List[int]) -> int:
     prefix, suffix, res = 0, 0, -float('inf')
     for i in range(len(nums)):
     prefix = nums[i] if not prefix else nums[i]*prefix
     suffix = nums[-i - 1] if not suffix else nums[-i - 1]*suffix
     res = max(res, prefix, suffix)
     return res
     ��ҿ�����������Щ�ط��ҵ���~?

     ���ߣ�suibianfahui
     ���ӣ�https://leetcode-cn.com/problems/maximum-product-subarray/solution/ti-gong-yi-chong-ondan-bu-shi-dong-tai-gui-hua-de-/
     ��Դ�����ۣ�LeetCode��
     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

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