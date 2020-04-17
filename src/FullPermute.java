import java.util.ArrayList;
import java.util.List;

public class FullPermute {

    public static List<List<Integer>> permute(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    private static List<List<Integer>> func(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        // 只有一个元素的时候，只有一个解，直接返回
        if (start == end) {
            List<Integer> l = new ArrayList<>(1);
            l.add(nums[start]);
            result.add(l);
            return result;
        } else {
            // 取出第一个元素，递归生成后续元素的解
            List<List<Integer>> subResult = func(nums, start + 1, end);
            // 将第一个元素插入递归生成的结果，生成全排列
            for (List<Integer> list : subResult) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> temp = new ArrayList<>(list.size() + 1);
                    temp.addAll(list);
                    temp.add(i, nums[start]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> result = permute(a);
        System.out.println(result);
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