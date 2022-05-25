package 学习笔记.读书笔记.程序员代码面试指南.第5章_字符串问题.最小包含子串的长度;

/**
 * @author SongShengLin
 * @date 2022/1/28 8:33 AM
 * @description
 */
public class Solution {
    /**
     * 最小覆盖子串长度
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出：最下子串"BANC",返回0
     */
    public int minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();

        int[] map = new int[256];
        for (char c : cs2) {
            map[c]++;
        }

        int left = 0, right = 0;
        int match = cs2.length;
        int minLen = Integer.MAX_VALUE;

        while (right < cs1.length) {
            map[cs1[right]]--;
            // 还可以匹配
            if (map[cs1[right]] >= 0) {
                match--;
            }

            if (match == 0) {
                // 左指针<0的表示对于匹配t无用,需要加1
                while (map[cs1[left]] < 0) {
                    map[cs1[left++]]++;
                }

                minLen = Math.min(minLen, right - left + 1);

                // 重新从匹配while=0的后一个数再计算，找最小匹配
                match++;
                map[cs1[left++]]++;

            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cabwefgewcwaefgcf";
        String t = "cwae";
        System.out.println(solution.minWindow(s, t));
    }
}
