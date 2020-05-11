/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package window;

/**
 *
 *
 * 3. 无重复字符的最长子串
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * @author longfei.wlf
 * @version $Id: LengthOfLongestSubstring.java, v 0.1 2020-05-11 9:04 PM longfei.wlf Exp $$
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        int left = 0;
        int right = 0;
        int[] window = new int[256];

        while (right < len) {
            // move right
            char c = s.charAt(right++);
            window[c]++;

            // untill valid
            while (window[c] > 1) {
                // move left
                char d = s.charAt(left);
                window[d]--;
                left++;
            }
            // update max
            max = Math.max(right - left, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}