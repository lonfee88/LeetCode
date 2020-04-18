package dp;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        // 注意遍历边界为[1,n]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("distance", "springbok"));
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