/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。 
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
   [1,2,2],
   [5]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

        // 当前元素加进来一定不合适
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
        // 去除重复
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(res, cur, candidates, target, sum, index + 1);

    }
}