package dp;

public class Knapsack {

    private int max;

    public int pack(int[] w, int[] v, int bagV) {
        max = 0;
        helper(w, v, bagV, 0, 0, 0);
        return max;
    }

    /**
     *
     * 回溯法
     * 
     * @param w
     * @param v
     * @param bagV
     * @param index
     * @param wSum
     * @param vSum
     */
    void helper(int[] w, int[] v, int bagV, int index, int wSum, int vSum) {
        if (index == w.length) {
            return;
        }

        if (wSum + w[index] <= bagV) {
            // add
            max = Math.max(max, vSum + v[index]);
            helper(w, v, bagV, index + 1, wSum + w[index], vSum + v[index]);
            //remove
            helper(w, v, bagV, index + 1, wSum, vSum);
        }
    }

    /**
     *
     * 动态规划
     *
     * @param w
     * @param v
     * @param bagV
     * @return
     */
    public int knapsack(int[] w, int[] v, int bagV) {
        //动态规划表,其中i表示物品，j表示剩余的容积
        int[][] dp = new int[w.length][bagV + 1];
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= bagV; j++) {
                //如果待添加的元素体积大于背包剩余体积，则取剩余体积为上一个体积
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                //如果不大于剩余体积，则取待添加物品 加入或不加入背包后的最大值
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[w.length - 1][bagV];
    }

    public static void main(String[] args) {
        int[] w = { 0, 2, 3, 4, 1 }; //商品的体积2、3、4、5
        int[] v = { 0, 3, 4, 5, 6 }; //商品的价值3、4、5、6
        int bagV = 8; //背包大小
        System.out.println(new Knapsack().knapsack(w, v, bagV));
        System.out.println(new Knapsack().pack(w, v, bagV));

    }
}