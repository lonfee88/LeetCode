package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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