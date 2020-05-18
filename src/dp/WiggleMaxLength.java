/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

/**
 *
 *
 * 376. �ڶ�����
 �����������֮��Ĳ��ϸ���������͸���֮�佻�棬���������г�Ϊ�ڶ����С���һ���������ڵĻ���������������������������Ԫ�ص�����Ҳ�ǰڶ����С�

 ���磬 [1,7,4,9,2,5] ��һ���ڶ����У���Ϊ��ֵ (6,-3,5,-7,3) ������������ֵġ��෴, [1,4,7,2,5] �� [1,7,4,5,5] ���ǰڶ����У���һ����������Ϊ����ǰ������ֵ�����������ڶ�����������Ϊ�������һ����ֵΪ�㡣

 ����һ���������У�������Ϊ�ڶ����е�������еĳ��ȡ� ͨ����ԭʼ������ɾ��һЩ��Ҳ���Բ�ɾ����Ԫ������������У�ʣ�µ�Ԫ�ر�����ԭʼ˳��

 ʾ�� 1:

 ����: [1,7,4,9,2,5]
 ���: 6
 ����: �������о�Ϊ�ڶ����С�
 ʾ�� 2:

 ����: [1,17,5,10,13,15,10,5,16,8]
 ���: 7
 ����: ������а�����������Ϊ 7 �ڶ����У�����һ����Ϊ[1,17,10,13,10,16,8]��
 ʾ�� 3:

 ����: [1,2,3,4,5,6,7,8,9]
 ���: 2
 ����:
 ���ܷ��� O(n) ʱ�临�Ӷ���ɴ���?

 
 * @author longfei.wlf
 * @version $Id: WiggleMaxLength.java, v 0.1 2020-05-18 6:40 PM longfei.wlf Exp $$
 */
public class WiggleMaxLength {

    /**
     *
     * https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode/
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    /**
     *
     * �Ż�����
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}