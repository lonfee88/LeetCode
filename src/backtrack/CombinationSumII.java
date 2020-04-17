/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/submissions/
 *
 * @author longfei.wlf
 * @version $Id: CombinationSumII.java, v 0.1 2020年04月03日 9:58 PM longfei.wlf Exp $
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0, 0);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target,
                        int sum, int index) {
        if (index == candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        // // 当前元素加进来一定不合适
        if (sum + candidates[index] > target) {
            // 直接下一个元素
            helper(res, cur, candidates, target, sum, index + 1);
            return;
        }

        // 加进当前元素
        cur.add(candidates[index]);
        sum += candidates[index];
        helper(res, cur, candidates, target, sum, index + 1);

        // 回溯
        cur.remove(cur.size() - 1);
        sum -= candidates[index];
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(res, cur, candidates, target, sum, index + 1);

    }
}