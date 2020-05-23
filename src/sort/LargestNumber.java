/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package sort;

import java.util.Arrays;

/**
 * @author longfei.wlf
 * @version $Id: LargestNumber.java, v 0.1 2020-05-23 4:08 PM longfei.wlf Exp $$
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // ���ݱ���ҲComparator��ͬһ���ͣ�int���У��ǰ�װ����
        //        Arrays.sort(strs, new Comparator<String>() {
        //            public int compare(String a, String b) {
        //                return (b+a).compareTo(a+b);
        //            }
        //        });
        // ����b+a��a+b�Ƚϣ� 1. ����˳�� 2. b��a�ȽϽ������
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        // ǰ��0�жϣ������λ��0���ض�ȫ��0
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        return result.toString();
    }
}