package window;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC"
                , "ABC"));
    }
}