package search;

/**
 *
 *  ×Ö½ÚÈıÃæÌâ£¬2020Äê06ÔÂ10ÈÕ
 * 
 * Ò»¸öÉıĞòÊı×éA£¬²éÕÒ±ÈÈÎÒâÊı×ÖaĞ¡µÄ×î´óµÄÊı
     A=1 3 5 7 9
     a=8

    ·µ»Ø7
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
        // ÏÈ´¦Àí×óÓÒ±ß½ç£¬È»ºó²éÕÒ±Ø¶¨ÂäÔÚ·¶Î§ÄÚ£¬²éÕÒºóÎŞĞèÅĞ¶Ï±ß½ç
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
        // ¿ÉÄÜÂäÔÚ×ó±ß£¬Ò²¿ÉÄÜÂäÔÚÓÒ±ß
        if (A[start] >= a) {
            return A[start - 1];
        }
        return A[start];
    }
}