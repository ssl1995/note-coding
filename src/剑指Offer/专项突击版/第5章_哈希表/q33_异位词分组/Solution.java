package 剑指Offer.专项突击版.第5章_哈希表.q33_异位词分组;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/10/6 11:39 上午
 * @description
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 异位词分组，用Map<每个单词排序后的新单词，一个链表>
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            // 使用库函数将单词排序
            // 如果不让用库函数，就用int[]存次数，sb添加字母+次数，见力扣49题
            Arrays.sort(cs);

            String sorted = new String(cs);
            map.putIfAbsent(sorted, new LinkedList<>());
            map.get(sorted).add(s);
        }
        return new LinkedList<>(map.values());
    }
}
