/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longfei.wlf
 * @version $Id: SubsetII.java, v 0.1 2020年04月02日 9:59 PM longfei.wlf Exp $
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[index]);
        helper(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        // 递归是倒序执行的，先去掉的是最后一个2；所以在去掉第一个2的时候，不应该再把第二个2再加进来
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        helper(res, cur, nums, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> res = new SubsetII().subsetsWithDup(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}