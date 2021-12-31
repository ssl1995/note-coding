package 刷题笔记.力扣.LC49_字母异位词分组;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 由于都是英文小写字母，可用数组保存次数 = 相当于不用库函数，自己自定义排序
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();// 用临时sb存字母+次数的逻辑：比如dba存a1b1d1
            for (int i = 0; i < 26; i++) {
                if (num[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(num[i]);
                }
            }

            String sorted = sb.toString();
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
