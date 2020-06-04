/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

/**
 *
 *
 * https://leetcode-cn.com/problems/word-search/
 *
 * 79. 单词搜索
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true
 给定 word = "SEE", 返回 true
 给定 word = "ABCB", 返回 false


 提示：

 board 和 word 中只包含大写和小写英文字母。
 1 <= board.length <= 200
 1 <= board[i].length <= 200
 1 <= word.length <= 10^3
 *
 * @author longfei.wlf
 * @version $Id: WordFind.java, v 0.1 2020-05-24 5:57 PM longfei.wlf Exp $$
 */
public class WordFind {
    // 使用成员变量，较少递归调用传参
    private int[]       index1 = { -1, 1, 0, 0 };
    private int[]       index2 = { 0, 0, -1, 1 };

    private char[][]    board;
    private String      word;

    private int         m;
    private int         n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;
        this.word = word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param i
     * @param j
     * @param start 使用start索引
     * @return
     */
    private boolean find(int i, int j, int start) {
        System.out.println(String.format("[%d][%d]:%s ________ ", i, j, word));
        // base case
        // 已匹配到最后一个字符
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        // 相等进入下一个
        // 递归避免写整个的for循环，只针对当前的选择做for循环
        if (board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for (int l = 0; l < index1.length; l++) {
                int newX = i + index1[l];
                int newY = j + index2[l];
                // 没访问过才进行的递归调用
                if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY] == true) {
                    continue;
                }
                if (find(newX, newY, start + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        System.out.println(new WordFind().exist(board, "AAB"));

    }
}