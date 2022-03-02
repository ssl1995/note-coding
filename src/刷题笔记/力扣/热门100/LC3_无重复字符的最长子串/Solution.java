package 刷题笔记.力扣.热门100.LC3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/1/18 9:19 AM
 * @description
 */
public class Solution {
    /**
     * 无重复字符的最长子串
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }

        int pre = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) >= pre) {
                pre = map.get(s.charAt(i));
            }
            max = Math.max(max, i - pre);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
