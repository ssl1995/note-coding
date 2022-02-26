package 刷题笔记.力扣.热门100.LC438_找到字符串中所有字符异位词;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/26 6:25 PM
 * @description
 */
public class Solution1 {
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
        int m = s.length();
        int n = p.length();
        // s,p只包含小写字母,只用26个字母即可;否则，用256即可
        int[] sMap = new int[26];
        // pMap:记录p中每个单词出现的次数
        int[] pMap = new int[26];
        for (int i = 0; i < n; i++) {
            pMap[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        // 双指针
        int left = 0;
        for (int right = 0; right < m; right++) {
            int j = s.charAt(right) - 'a';
            sMap[j]++;
            // 右指针指向map要大，左指针后移
            while (sMap[j] > pMap[j]) {
                int i = s.charAt(left) - 'a';
                sMap[i]--;
                left++;
            }
            // 匹配成功：说明长度相等
            if (right - left + 1 == n) {
                res.add(left);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(solution.findAnagrams(s, t));
    }
}
