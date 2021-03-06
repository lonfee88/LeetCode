package search;

/**
 *
 *  字节三面题，2020年06月10日
 * 
 * 一个升序数组A，查找比任意数字a小的最大的数
     A=1 3 5 7 9
     a=8

    返回7
 *
 */

public class Find {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Find main = new Find();
        int[] A = new int[] { 1, 3, 5, 7, 9 };
        System.out.println(main.find(A, 10));
        System.out.println(main.find(A, 8));
        System.out.println(main.find(A, 1));
        System.out.println(main.find(A, 3));
    }

    public int find(int[] A, int a) {
        int n = A.length;
        // 先处理左右边界，然后查找必定落在范围内，查找后无需判断边界
        if (n == 0 || A[0] >= a) {
            return -1;
        }
        if (A[n - 1] < a) {
            return A[n - 1];
        }
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int num = A[mid];
            if (num < a) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // 可能落在左边，也可能落在右边
        if (A[start] >= a) {
            return A[start - 1];
        }
        return A[start];
    }
}