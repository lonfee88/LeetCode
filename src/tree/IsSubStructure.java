/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package tree;

/**
 * @author longfei.wlf
 * @version $Id: IsSubStructure.java, v 0.1 2020-06-06 5:42 PM longfei.wlf Exp $$
 */
public class IsSubStructure {
    // Definition for a binary tree node.
    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }

        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

        /**
         * 不用使用队列，递归调用即可
         */
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(A);
        // while(!queue.isEmpty()){
        //     TreeNode node = queue.poll();
        //     if(isSub(node, B)){
        //         return true;
        //     }
        //     if(node.left != null){
        //         queue.offer(node.left);
        //     }
        //     if(node.right != null){
        //         queue.offer(node.right);
        //     }
        // }

        // return false;
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        System.out.println("A" + A.val + ",B:" + B.val);

        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}