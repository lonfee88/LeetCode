/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package BFS;

import java.util.*;

/**
 *
 *
 * https://leetcode-cn.com/problems/word-ladder/
 *
 *
 * 127. ���ʽ���
 �����������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���

 ÿ��ת��ֻ�ܸı�һ����ĸ��
 ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 ˵��:

 ���������������ת�����У����� 0��
 ���е��ʾ�����ͬ�ĳ��ȡ�
 ���е���ֻ��Сд��ĸ��ɡ�
 �ֵ��в������ظ��ĵ��ʡ�
 ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 ʾ�� 1:

 ����:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 ���: 5

 ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 �������ĳ��� 5��
 ʾ�� 2:

 ����:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 ���: 0

 ����: endWord "cog" �����ֵ��У������޷�����ת����
 *
 * @author longfei.wlf
 * @version $Id: LadderLength.java, v 0.1 2020-05-23 9:52 PM longfei.wlf Exp $$
 */
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            // ��ó��ȣ�һ�齫����Ķ�����
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return count;
                }
                for (String word : wordList) {
                    if (!set.contains(word) && isLike(str, word)) {
                        queue.add(word);
                        set.add(word);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isLike(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(LadderLength.ladderLength("hit", "cog",
            new ArrayList<>(Arrays.asList("hot", "dot", "tog", "cog"))));

    }
}