/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longfei.wlf
 * @version $Id: PathSum.java, v 0.1 2020-06-06 11:15 PM longfei.wlf Exp $$
 */
public class PathSum {

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            travel(root, sum, res, new ArrayList<Integer>());
        }
        return res;
    }

    private void travel(TreeNode node, int sum, List<List<Integer>> res, List<Integer> cur) {
        if (node == null) {
            return;
        }

        cur.add(node.val);
        sum -= node.val;

        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(cur));
            // 不能return,还没有remove，会导致结果中多出无效的值
            // return;
        }

        travel(node.left, sum, res, cur);
        travel(node.right, sum, res, cur);

        cur.remove(cur.size() - 1);
    }
}