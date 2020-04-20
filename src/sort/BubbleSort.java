/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package sort;

import java.util.Arrays;

/**
 * @author longfei.wlf
 * @version $Id: BubbleSort.java, v 0.1 2020-04-20 11:19 AM longfei.wlf Exp $$
 */
public class BubbleSort {
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 5, 4, 9, 1, 7, 6, 2, 3, 8 };
        new BubbleSort().sort(a);
        System.out.println(Arrays.toString(a));
    }
}