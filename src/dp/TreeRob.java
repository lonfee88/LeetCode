/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author longfei.wlf
 * @version $Id: TreeRob.java, v 0.1 2020-05-30 11:23 AM longfei.wlf Exp $$
 */
public class TreeRob {
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *
     * 树形dp
     * dp[0]: 不偷父节点，子节点max(偷子节点，不偷子节点)
     * dp[1]:偷父节点，子节点不可偷，node.val+left[0]+right[0]
     *
     */

    public int rob(TreeNode root) {
        int[] money = dfs(root);
        return Math.max(money[0], money[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        // node节点不偷，子节点可偷可不偷，取最大值
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // node节点偷，子节点不可偷
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }

    /**
     *
     * 备忘录 + 暴力递归
     *
     */

    private Map<TreeNode, Integer> robMap = new HashMap<>();

    public int rob1(TreeNode root) {
        return helper(root);
    }

    int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (robMap.containsKey(node)) {
            return robMap.get(node);
        }
        int money = node.val;
        if (node.left != null) {
            money += helper(node.left.left) + helper(node.left.right);
        }
        if (node.right != null) {
            money += helper(node.right.left) + helper(node.right.right);
        }

        money = Math.max(money, helper(node.left) + helper(node.right));
        robMap.put(node, money);
        return money;
    }
}