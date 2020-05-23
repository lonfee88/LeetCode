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
        // 数据必须也Comparator有同一类型，int不行，非包装类型
        //        Arrays.sort(strs, new Comparator<String>() {
        //            public int compare(String a, String b) {
        //                return (b+a).compareTo(a+b);
        //            }
        //        });
        // 必须b+a和a+b比较： 1. 降序顺序 2. b和a比较结果不对
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        // 前导0判断，如果首位是0，必定全是0
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