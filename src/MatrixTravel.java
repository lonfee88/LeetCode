/**
 *
 * ������12. �����е�·��
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ��ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ�����һ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ����磬�������3��4�ľ����а���һ���ַ�����bfce����·����·���е���ĸ�üӴֱ������

 [["a","b","c","e"],
 ["s","f","c","s"],
 ["a","d","e","e"]]

 �������в������ַ�����abfb����·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���������ӡ�

 ?

 ʾ�� 1��

 ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 �����true
 ʾ�� 2��

 ���룺board = [["a","b"],["c","d"]], word = "abcd"
 �����false
 ��ʾ��

 1 <= board.length <= 200
 1 <= board[i].length <= 200
 ע�⣺��������վ 79 ����ͬ��https://leetcode-cn.com/problems/word-search/

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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