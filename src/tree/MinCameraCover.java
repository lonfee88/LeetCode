/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package tree;

/**
 *
 * 968. ��ض�����
 ����һ�������������������Ľڵ��ϰ�װ����ͷ��

 �ڵ��ϵ�ÿ����Ӱͷ�����Լ����丸����������ֱ���Ӷ���

 �������������нڵ��������С����ͷ������



 ʾ�� 1��



 ���룺[0,0,null,0,0]
 �����1
 ���ͣ���ͼ��ʾ��һ̨����ͷ���Լ�����нڵ㡣
 ʾ�� 2��



 ���룺[0,0,null,0,null,0,null,null,0]
 �����2
 ���ͣ���Ҫ������������ͷ�������������нڵ㡣 ��ͼ��ʾ������ͷ���õ���Чλ��֮һ��

 ��ʾ��

 �������Ľڵ����ķ�Χ�� [1, 1000]��
 ÿ���ڵ��ֵ���� 0��
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
     1.��װ��������
     2.�����ӣ�
     3.δ������

     ��״̬��DFS

     * @param node
     * @return
     */
    int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }
        // �ȴ����ӽڵ㣬�����ڵ�
        int l = dfs(node.left);
        int r = dfs(node.right);
        //�ӽڵ�δ����أ���Ҫ��װ����ͷ
        if (l == 3 || r == 3) {
            num++;
            return 1;
        }
        // �ӽڵ��Ѱ�װ����ͷ
        if (l == 1 || r == 1) {
            return 2;
        }
        // δ�����
        return 3;
    }

}