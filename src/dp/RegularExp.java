/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package dp;

/**
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author longfei.wlf
 * @version $Id: RegularExp.java, v 0.1 2020-06-03 9:20 PM longfei.wlf Exp $$
 */
public class RegularExp {
    /**
     *
     * https://www.bilibili.com/video/BV184411U7rw?from=search&seid=16874685797039520928
     *
     * ��̬�滮������O(mn)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        // ��ʼ��
        dp[0][0] = true;
        // �մ���a*b*֮���ƥ�䣬������true
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // ƥ��Ļ���ֱ��ǰ��
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // ƥ����Σ�ֱ�Ӻ���x*
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                    // ƥ��һ�Σ�ǰ�����ַ�ƥ�����.
                    else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    // �ݹ鷽����ָ������
    public boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstMath = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // ��*�ģ�ƥ����λ���һ��
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // ���
            // һ�ε�ǰ����firstMatch
            return isMatch(s, p.substring(2)) || firstMath && isMatch(s.substring(1), p);
        }
        // û��*�����,��ǰ��1
        else {
            return firstMath && isMatch(s.substring(1), p.substring(1));
        }
    }
}