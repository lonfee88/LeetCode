/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package tree;

/**
 *
 * 968. 监控二叉树
 给定一个二叉树，我们在树的节点上安装摄像头。

 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

 计算监控树的所有节点所需的最小摄像头数量。



 示例 1：



 输入：[0,0,null,0,0]
 输出：1
 解释：如图所示，一台摄像头足以监控所有节点。
 示例 2：



 输入：[0,0,null,0,null,0,null,null,0]
 输出：2
 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

 提示：

 给定树的节点数的范围是 [1, 1000]。
 每个节点的值都是 0。
 *
 * @author longfei.wlf
 * @version $Id: MinCameraCover.java, v 0.1 2020-05-22 11:53 AM longfei.wlf Exp $$
 */
public class MinCameraCover {

    // Definition for a binary tree node.
    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int num;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 3) {
            num++;
        }
        return num;
    }

    /**
     *
     1.安装监视器；
     2.被监视；
     3.未被监视

     带状态的DFS

     * @param node
     * @return
     */
    int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }
        // 先处理子节点，后处理父节点
        int l = dfs(node.left);
        int r = dfs(node.right);
        //子节点未被监控，需要安装摄像头
        if (l == 3 || r == 3) {
            num++;
            return 1;
        }
        // 子节点已安装摄像头
        if (l == 1 || r == 1) {
            return 2;
        }
        // 未被监控
        return 3;
    }

}