/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package stack;

import java.util.Stack;

/**
 *
 * 84. 柱状图中最大的矩形
 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。





 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。





 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。



 示例:

 输入: [2,1,5,6,2,3]
 输出: 10
 通过次数53,143提交次数132,767
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

        // 左右哨兵为0
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;
        // 遍历新数组长度 len + 2
        for (int i = 1; i < len + 2; i++) {
            // 单调栈，出栈一次后再peek为左边界
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                // 左右边界不包含
                int width = i - stack.peek() - 1;
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }
        return area;
    }

}