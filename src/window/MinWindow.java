package window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

 示例：

 输入: S = "ADOBECODEBANC", T = "ABC"
 输出: "BANC"
 说明：

 如果 S 中不存这样的子串，则返回空字符串 ""。
 如果 S 中存在这样的子串，我们保证它是唯一的答案。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-window-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int maxStrSize = s.length() + 1;
        String result = "";
        int start = 0, end = 0;
        int match = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (end < s.length()) {
            char c = s.charAt(end);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == needs.get(c)) {
                    match++;
                }
            }
            while (match == needs.size()) {
                if (end - start + 1 <= maxStrSize) {
                    maxStrSize = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                c = s.charAt(start);
                if (needs.containsKey(c)) {
                    if (window.get(c) == needs.get(c)) {
                        match--;
                    }
                    window.put(c, window.get(c) - 1);
                }
                start++;
            }
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}