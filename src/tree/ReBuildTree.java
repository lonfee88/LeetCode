/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package tree;

import java.util.Arrays;

/**
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 ?

 例如，给出

 前序遍历 preorder =?[3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7
 ?

 限制：

 0 <= 节点个数 <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
 * @author longfei.wlf
 * @version $Id: ReBuildTree.java, v 0.1 2020-05-10 8:45 PM longfei.wlf Exp $$
 */
public class ReBuildTree {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        int index = -1;
        // in order
        for (int i = 0; i < n; i++) {
            if (preorder[0] == inorder[i]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index),
            Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length),
            Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

}