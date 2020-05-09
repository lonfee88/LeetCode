package string;

public class HuiWen {
    public String getMaxStr(String s) {
        // 空串直接返回空
        if (s == null || s.length() == 0) {
            return "";
        }
        // 长度为1的是回文字串
        int len = s.length();
        if (len == 1) {
            return s;
        }
        // 结果初始为第一个字符
        String result = s.substring(0, 1);
        // 回文字串长度可能为奇数，也可能为偶数
        for (int i = 0; i + 1 < len; i++) {
            // 以i为中心
            String subStr1 = helper(s, i, i);
            if (subStr1.length() > result.length()) {
                result = subStr1;
            }
            // 以i,i+1为中心
            String subStr2 = helper(s, i, i + 1);
            if (subStr2.length() > result.length()) {
                result = subStr2;
            }
        }
        return result;
    }

    // 以i,j为中心的最长回文字串
    private String helper(String s, int i, int j) {
        int len = s.length();
        while (i > 0 && j + 1 < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return s.substring(i, j + 1);
        } else {
            return s.substring(i + 1, j);
        }
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
    }
}