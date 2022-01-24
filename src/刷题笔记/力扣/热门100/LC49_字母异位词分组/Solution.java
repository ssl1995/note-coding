package 刷题笔记.力扣.热门100.LC49_字母异位词分组;

import java.util.*;

public class Solution {

    /**
     * 字母异位词分组
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希表<异位词排序后的值(每一组异位词排序后的值都相同)，同组异位词>
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();

            Arrays.sort(cs);
            String sorted = new String(cs);
            // putIfAbsent
            map.putIfAbsent(sorted, new LinkedList<>());
            map.get(sorted).add(s);
        }
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}
