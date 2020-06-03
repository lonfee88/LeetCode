/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package stack;

import java.util.Stack;

/**
 *
 * 84. ��״ͼ�����ľ���
 ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��

 ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������





 ��������״ͼ��ʾ��������ÿ�����ӵĿ��Ϊ 1�������ĸ߶�Ϊ [2,1,5,6,2,3]��





 ͼ����Ӱ����Ϊ���ܹ��ճ�������������������Ϊ 10 ����λ��



 ʾ��:

 ����: [2,1,5,6,2,3]
 ���: 10
 ͨ������53,143�ύ����132,767
 *
 * @author longfei.wlf
 * @version $Id: LargestRectangleArea_84.java, v 0.1 2020-05-30 4:41 PM longfei.wlf Exp $$
 */
public class LargestRectangleArea_84 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        // �����ڱ�Ϊ0
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;
        // ���������鳤�� len + 2
        for (int i = 1; i < len + 2; i++) {
            // ����ջ����ջһ�κ���peekΪ��߽�
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                // ���ұ߽粻����
                int width = i - stack.peek() - 1;
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }
        return area;
    }

}