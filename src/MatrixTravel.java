/**
 *
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

 [["a","b","c","e"],
 ["s","f","c","s"],
 ["a","d","e","e"]]

 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 ?

 示例 1：

 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 输出：true
 示例 2：

 输入：board = [["a","b"],["c","d"]], word = "abcd"
 输出：false
 提示：

 1 <= board.length <= 200
 1 <= board[i].length <= 200
 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class MatrixTravel {
    private int[][] DIRECTION = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;

        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] && find(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int row, int col, String word, int index, int[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = 1;
        for (int i = 0; i < DIRECTION.length; i++) {
            int newRow = row + DIRECTION[i][0];
            int newCol = col + DIRECTION[i][1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length
                || visited[newRow][newCol] == 1) {
                continue;
            }
            System.out.println(String.format("[%s,%s]:%c", newRow, newCol, word.charAt(index)));
            if (board[newRow][newCol] == word.charAt(index + 1)) {
                if (find(board, newRow, newCol, word, index + 1, visited)) {
                    return true;
                }
            }
        }
        visited[row][col] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        String word = "AAB";

        System.out.println(new MatrixTravel().exist(board, word));

    }
}