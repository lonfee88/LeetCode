public class Main {
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        return helper(root, false);
    }

    int helper(TreeNode node, boolean flag) {
        if (node == null) {
            return 0;
        }
        System.out.println(String.format("[%d]: " + flag, node.val));
        // 抢了parent
        if (flag) {
            // 当前节点不能抢
            return helper(node.left, false) + helper(node.right, false);
        }
        // 当前节点可抢，可不抢
        else {
            // left
            int tmp1 = helper(node.left, true) + helper(node.right, true) + +node.val;
            //right
            int tmp2 = helper(node.left, false) + helper(node.right, false);
            return Math.max(tmp1, tmp2);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        t1.right = t3;
        t2.right = t4;

        System.out.println(new Main().rob(root));

    }
}