/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longfei.wlf
 * @version $Id: PerMute.java, v 0.1 2020年04月02日 10:40 PM longfei.wlf Exp $
 */
public class PerMute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), nums, visited);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> cur, int[] nums,
                               boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
            // 因为在循环里，删除状态后，会进行i++然后执行下一个，所以这里不用再递归
            //helper(res,cur,nums,visited);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = PerMute.permute(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}