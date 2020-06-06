/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longfei.wlf
 * @version $Id: Subset.java, v 0.1 2020年04月02日 9:09 PM longfei.wlf Exp $
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {

        if (index == nums.length) {
            // 必须在这里加，因为后面有两个递归调用的结果，会在这里用到
            // 只有所有元素都选择了选或者不选，才是一个完整的解
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        helper(res, cur, nums, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        List<List<Integer>> res = new Subset().subsets(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

}