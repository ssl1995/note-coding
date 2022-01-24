package 刷题笔记.力扣.热门100.LC49_字母异位词分组.练习;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2022/1/24 11:09 PM
 * @description
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();

            Arrays.sort(cs);
            String sorted = new String(cs);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
