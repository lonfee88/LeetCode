/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package stack;

import java.util.Stack;

/**
 *
 * 42. ����ˮ
 ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��



 ������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��

 ʾ��:

 ����: [0,1,0,2,1,0,1,3,2,1,2,1]
 ���: 6
 ͨ������104,112�ύ����203,846
 *
 * @author longfei.wlf
 * @version $Id: Trap_42.java, v 0.1 2020-05-30 8:11 PM longfei.wlf Exp $$
 */
public class Trap_42 {

    /**
     *
     * ����ջ�ⷨ
     *
     * ��ʵֻ��ĳ���ڵ������max��أ����Բ���˫ָ�뷽��
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[stack.peek()], height[i]) - height[index])
                           * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return sum;
    }
}