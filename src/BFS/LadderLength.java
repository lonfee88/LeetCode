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
 * 127. 单词接龙
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 示例 1:

 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 输出: 5

 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 返回它的长度 5。
 示例 2:

 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: 0

 解释: endWord "cog" 不在字典中，所以无法进行转换。
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
            // 获得长度，一遍将当层的都出队
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