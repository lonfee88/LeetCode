/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package others;

import java.util.Arrays;

/**
 * @author longfei.wlf
 * @version $Id: SpiralOrder.java, v 0.1 2020-06-04 5:36 PM longfei.wlf Exp $$
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++)
                res[x++] = matrix[t][i]; // left to right.
            if (++t > b)
                break;
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r)
                break;
            for (int i = r; i >= l; i--)
                res[x++] = matrix[b][i]; // right to left.
            if (t > --b)
                break;
            for (int i = b; i >= t; i--)
                res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[] { 1, 5, 9, 13 };
        matrix[1] = new int[] { 2, 6, 10, 14 };
        matrix[2] = new int[] { 3, 7, 11, 15 };
        matrix[3] = new int[] { 4, 8, 12, 16 };

        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(matrix)));
    }
}