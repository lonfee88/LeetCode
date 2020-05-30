/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package stack;

import java.util.Stack;

/**
 *
 * 42. 接雨水
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

 示例:

 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 输出: 6
 通过次数104,112提交次数203,846
 *
 * @author longfei.wlf
 * @version $Id: Trap_42.java, v 0.1 2020-05-30 8:11 PM longfei.wlf Exp $$
 */
public class Trap_42 {

    /**
     *
     * 单调栈解法
     *
     * 其实只和某个节点的左右max相关，可以采用双指针方法
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