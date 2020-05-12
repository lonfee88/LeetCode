/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package others;

/**
 *
 * yufeng
 *
 * # xiaofan.163@bytedance.com对所有人说： (3:18 下午)
 # ?描述信息?小明常常用BT下载连载电视剧、综艺观看。??因为种子、网络等诸多因素，可能不是所有的剧集都能现在下来，
 # 且现在的顺序也不一定按照从第一集到第n集排列。??请问：已知小明已下载的某部电视剧的剧集列表，
 # 求小明最多能连续观看多少集？??例如：episodes = 10, 1, 3, 4, 7, 6, 20, 5, 13, 23, 14??
 # 那么小明做多能连续看3, 4, 5, 6, 7共5集??希望时间复杂度O(N)?
 *
 * @author longfei.wlf
 * @version $Id: MaxEpisodes.java, v 0.1 2020-05-12 9:17 PM longfei.wlf Exp $$
 */
public class MaxEpisodes {
    private static int MAX_EP = 1000;

    public static int max(int N[]) {
        if (N.length == 0) {
            return 0;
        }
        int[] flag = new int[MAX_EP];
        for (int n : N) {
            flag[n] = 1;
        }
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < MAX_EP; i++) {
            if (flag[i] == 1 && (i == 0 || flag[i - 1] == 0)) {
                start = i;
            }
            if (flag[i] == 1 && (i == MAX_EP - 1 || flag[i + 1] == 0)) {
                end = i;
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] episodes = { 10, 1, 3, 4, 7, 6, 20, 5, 13, 23, 14 };
        System.out.println(MaxEpisodes.max(episodes));

    }
}