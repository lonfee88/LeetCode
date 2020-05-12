/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package others;

/**
 *
 * yufeng
 *
 * # xiaofan.163@bytedance.com��������˵�� (3:18 ����)
 # ?������Ϣ?С��������BT�������ص��Ӿ硢���չۿ���??��Ϊ���ӡ������������أ����ܲ������еľ缯��������������
 # �����ڵ�˳��Ҳ��һ�����մӵ�һ������n�����С�??���ʣ���֪С�������ص�ĳ�����Ӿ�ľ缯�б�
 # ��С������������ۿ����ټ���??���磺episodes = 10, 1, 3, 4, 7, 6, 20, 5, 13, 23, 14??
 # ��ôС��������������3, 4, 5, 6, 7��5��??ϣ��ʱ�临�Ӷ�O(N)?
 *
 * @author longfei.wlf
 * @version $Id: MaxEpisodes.java, v 0.1 2020-05-12 9:17 PM longfei.wlf Exp $$
 */
public class MaxEpisodes {
    private static int MAX_EP = 1000;

    public static int max(int N[]) {
        if (N.length == 0) {
            return 0;
        }
        int[] flag = new int[MAX_EP];
        for (int n : N) {
            flag[n] = 1;
        }
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < MAX_EP; i++) {
            if (flag[i] == 1 && (i == 0 || flag[i - 1] == 0)) {
                start = i;
            }
            if (flag[i] == 1 && (i == MAX_EP - 1 || flag[i + 1] == 0)) {
                end = i;
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] episodes = { 10, 1, 3, 4, 7, 6, 20, 5, 13, 23, 14 };
        System.out.println(MaxEpisodes.max(episodes));

    }
}