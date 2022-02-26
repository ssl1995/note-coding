package 刷题笔记.力扣.热门100.LC438_找到字符串中所有字符异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/26 6:25 PM
 * @description
 */
public class Solution {
    /**
     * 找到字符串中所有字符异位词
     * 输入: s = "cbaebabacd", p = "abc",s和p仅包含小写字母
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || (p.length() > s.length())) {
            return new ArrayList<>();
        }
        int n = p.length();
        int m = s.length();
        // s,p只包含小写字母,只用26个字母即可
        // sMap:记录s中每p长度单词出现的次数
        int[] sMap = new int[26];
        // pMap:记录p中每个单词出现的次数
        int[] pMap = new int[26];
        for (int i = 0; i < n; i++) {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        // 如果s,p第一个字母往后n个都匹配
        if (Arrays.equals(sMap, pMap)) {
            res.add(0);
        }

        for (int i = n; i < m; i++) {
            // 去掉之前位置记录
            sMap[s.charAt(i - n) - 'a']--;
            // 更新当前记录
            sMap[s.charAt(i) - 'a']++;
            // 判断是否相等
            if (Arrays.equals(sMap, pMap)) {
                // 注意下标变换
                res.add(i - n + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(solution.findAnagrams(s, t));
    }
}
