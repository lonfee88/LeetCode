/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

/**
 *
 * 最长连续子串【不是子序列】
 * 
 * https://www.nowcoder.com/practice/02e7cc263f8a49e8b1e1dc9c116f7602?tpId=179&&tqId=34113&rp=1&ru=/activity/oj&qru=/ta/exam-other/question-ranking
 *
 *
 * @author longfei.wlf
 * @version $Id: LongestSubstring.java, v 0.1 2020-06-03 5:45 PM longfei.wlf Exp $$
 */
public class LongestSubstring {
    /*
    * 最后的值不是dp[n][m];要取最值
    */

    public int findLongest(String A, int n, String B, int m) {
        // write code here
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] dp = new int[n][m];
        // 初始化初始值
        for (int i = 0; i < n; i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = A.charAt(0) == B.charAt(j) ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}