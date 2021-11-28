package 读书笔记.剑指Offer.第三版.第15章_图.q114_外星文字典;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/28 4:02 下午
 * @description
 */
public class Solution {

    public String alienOrder(String[] words) {
        // graph:键=结点，值=相邻排序比它大的结点
        Map<Character, Set<Character>> graph = new HashMap<>();
        // 结点入度
        Map<Character, Integer> inDegrees = new HashMap<>();
        // 找出words中所有的字母并初始化
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegrees.putIfAbsent(c, 0);
            }
        }
        // 从比较排序的words中两两相邻的单词中推出小->大的拓扑排序
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            // 后面的单词是前面单词的前缀，是无效输入，返回空字符串
            // 比如：abc,ab，是无效的输入
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegrees.put(c2, inDegrees.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Character c : inDegrees.keySet()) {
            if (inDegrees.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.remove();
            sb.append(c);

            for (char next : graph.get(c)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] word = {"ac", "ab", "bc", "zc", "zb"};
        System.out.println(solution.alienOrder(word));
    }

}


