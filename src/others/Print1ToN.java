package others;

/**
 * 17. 打印从 1 到最大的 n 位数
 *
 * https://cyc2018.github.io/CS-Notes/#/notes/17.%20%E6%89%93%E5%8D%B0%E4%BB%8E%201%20%E5%88%B0%E6%9C%80%E5%A4%A7%E7%9A%84%20n%20%E4%BD%8D%E6%95%B0
 *
 */
public class Print1ToN {

    public static void func(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print(number, 0, n);

    }

    private static void print(char[] number, int m, int n) {
        if (m < n) {
            for (int i = 0; i <= 9; i++) {
                number[m] = (char) (i + '0');
                print(number, m + 1, n);
                printNumber(number);
            }
        }
    }

    private static void printNumber(char[] number){
        int i=0;
        while(i<number.length && number[i]=='0'){
            i++;
        }
        while (i<number.length){
            System.out.print(number[i++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        func(1);
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