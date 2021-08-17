package 力扣.LC49_字母异位词分组;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] num = new int[26];// num存次数相当于排序
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
            String key = sb.toString();// 异位词相同的，肯定sb中存的相同
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}
