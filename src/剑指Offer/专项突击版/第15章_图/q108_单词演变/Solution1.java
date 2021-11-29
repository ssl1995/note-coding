package 剑指Offer.专项突击版.第15章_图.q108_单词演变;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/26 12:46 上午
 * @description
 */
public class Solution1 {
    // 双向广度优先搜索，节省了时间，提高了效率
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);

        while (!set1.isEmpty() && !set2.isEmpty()) {
            // set1设置为每次都是最短的那边
            if (set2.size() < set1.size()) {
                HashSet<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            // set3存放当前结点相邻的结点
            HashSet<String> set3 = new HashSet<>();
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return length;
                    }

                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            // 还有相邻结点没到达endWord,长度+1
            length++;
            // set1访问完，访问set1的相邻的所有结点=set3
            set1 = set3;
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

        Solution1 solution = new Solution1();
        System.out.println(solution.ladderLength(startWord, endWord, wordList));
    }
}
