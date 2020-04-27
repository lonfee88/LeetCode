package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

 示例:

 输入: [4, 6, 7, 7]
 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 说明:

 给定数组的长度不会超过15。
 数组中的整数范围是 [-100,100]。
 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-subsequences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length < 2) {
            return new ArrayList<>(res);
        }
        helper(nums, new ArrayList<>(), res, 0);
        return new ArrayList<>(res);
    }

    void helper(int[] nums, List<Integer> cur, Set<List<Integer>> res, int index) {
        if (index == nums.length) {
            if (cur.size() >= 2) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        // 确保是递增才加入
        if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[index]) {
            cur.add(nums[index]);
            helper(nums, cur, res, index + 1);
            cur.remove(cur.size() - 1);
            // 跳过连续的重复，但可能存在不连续的重复，比如1***1
            while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                index++;
            }
            helper(nums, cur, res, index + 1);
        } else {
            helper(nums, cur, res, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] w = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1 };
        System.out.println(new FindSubsequences().findSubsequences(w));
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