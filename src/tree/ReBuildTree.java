/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package tree;

import java.util.Arrays;

/**
 *
 * ����ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�

 ?

 ���磬����

 ǰ����� preorder =?[3,9,20,15,7]
 ������� inorder = [9,3,15,20,7]
 �������µĶ�������

 3
 / \
 9  20
 /  \
 15   7
 ?

 ���ƣ�

 0 <= �ڵ���� <= 5000

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 
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