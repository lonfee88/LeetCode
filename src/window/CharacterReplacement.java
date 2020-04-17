package window;

/**
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://blog.csdn.net/qq_43152052/article/details/102840715
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (k >= s.length() - 1) {
            return s.length();
        }
        int left = 0, right = 0;
        int result = 0;
        int[] charCount = new int[256];
        int maxChar = 0;

        while (right < s.length()) {
            // 一直右滑，直到当前窗口不能通过替换k次得到结果
            charCount[s.charAt(right) - 'A']++;
            maxChar = Math.max(maxChar, charCount[s.charAt(right) - 'A']);
            System.out.println("add right:" + right);
            // 不满足结果的时候，收缩窗口一次，使得满足条件，right继续移动
            if (maxChar + k < right - left + 1) {
                // window.remove
                charCount[s.charAt(left) - 'A']--;
                left++;
                System.out.println("add left:" + left);
            }
            // update result
            result = Math.max(right - left + 1, result);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "ABCBA";
        System.out.println(new CharacterReplacement().characterReplacement(a, 1));
    }

    // 单个数字
    /*
    Scanner sc=new Scanner(System.in);
    int n;
        while(sc.hasNext())
    {
        n=sc.nextInt();
        System.out.println(func(n));
    }
    */

    // 先输入组数，在输入多个数字
    /*
    Scanner sc = new Scanner(System.in);
    int n;
        while (sc.hasNext()) {
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Integer[] result = func(n, arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
     */

    //输入空格分隔的多组数字
    /*
    Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            func(str);
        }
     */
}