import java.util.*;

public class Main {
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // 0 û��ɫ  1 ��ɫ  2 ��ɫ
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                // ��ɫ
                color[i] = 1;

                while (!stack.isEmpty()) {
                    int tmp = stack.pop();
                    int[] neig = graph[tmp];
                    for (int node : neig) {
                        if (color[node] == 0) {
                            // ��ɫ
                            color[node] = color[tmp] == 1 ? 2 : 1;
                            stack.push(node);
                        } else if (color[node] != color[tmp]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[4][2];
        // [[1,3],[0,2],[1,3],[0,2]]
        prerequisites[0] = new int[] { 1, 3 };
        prerequisites[1] = new int[] { 0, 2 };
        prerequisites[2] = new int[] { 1, 3 };
        prerequisites[3] = new int[] { 0, 2 };
        System.out.println(new Main().isBipartite(prerequisites));

    }
}