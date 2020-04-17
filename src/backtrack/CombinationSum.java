/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 *
 * @author longfei.wlf
 * @version $Id: combinationSum.java, v 0.1 2020年04月03日 9:57 PM longfei.wlf Exp $
 */
public class CombinationSum {

    /**
     *
     * 别人的算法：
     * 1. 直接用target--算边界，不用引入sum
     * 2. target<=0作为结束条件，而不用管index，因为当前元素可以重复使用，只到target<=0而不担心越界
     * 3. for循环：当前元素选了以后，对后续的每个元素执行加入和回溯
     * 4. for循环的回溯后面，不应该再递归调用，因为执行了i++。所以当前元素加或不加的情况，都会i++后继续递归
     *
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }

        helper(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target,
                        int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 加进当前元素
            cur.add(candidates[i]);
            helper(res, cur, candidates, target - candidates[i], i);
            // 回溯
            cur.remove(cur.size() - 1);
        }
    }

    /**
     *
     * 自己的算法
     *
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> newCandidates = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int count = target / candidates[i];
            for (int j = 0; j < count; j++) {
                newCandidates.add(candidates[i]);
            }
        }
        Integer[] list = newCandidates.toArray(new Integer[newCandidates.size()]);

        helper(res, new ArrayList<>(), list, target, 0, 0);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, Integer[] candidates, int target, int sum, int index) {
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
        // 去重
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(res, cur, candidates, target, sum, index + 1);
    }
     **/
}