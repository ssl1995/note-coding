package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第15章_图.q108_单词演变;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/26 12:46 上午
 * @description
 */
public class Solution {
    // 单向广度优先搜索
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        HashSet<String> notVisited = new HashSet<>(wordList);

        int length = 1;
        queue1.add(beginWord);

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            // 遇见endWord，就返回当前长度
            if (word.equals(endWord)) {
                return length;
            }

            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }

            if (queue1.isEmpty()) {
                // 每次交换队列，距离初始节点beginWord距离都+1
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }

    /**
     * 将word单词中一个字母修改成另一个字母，返回所有结果
     *
     * @param word 单词
     * @return 改变一个单词的结果
     */
    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char old = cs[i];
            // 将一个单词修改成另一个字母
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (old != ch) {
                    cs[i] = ch;
                    neighbors.add(new String(cs));
                }
            }
            // 变回原样，继续下个字母
            cs[i] = old;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        Solution solution = new Solution();
        System.out.println(solution.ladderLength(startWord, endWord, wordList));
    }
}
