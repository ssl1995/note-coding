package 刷题笔记.力扣.热门100.LC3_无重复字符的最长子串;

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
     * 概念：1.子串 = 连续的 2.子序列 = 不连续的
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] cs = s.toCharArray();
        // 1.记录i位置前一个出现的下标,用一个map数组记录
        // preMap:key=该字符，value=该字符串上一次出现的下标
        int[] preIMap = new int[256];
        // 初始化map，每个字符上一次出现的下标为-1
        for (int i = 0; i < 256; i++) {
            preIMap[i] = -1;
        }

        // 2.i-1位置能往前扩多远
        // cs[i-1]的最长无重复开始位置的前一个位置
        int pre = -1;

        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            // pre始终指向最右边的位置，因为离i位置最近且中间没有重复元素
            pre = Math.max(pre, preIMap[cs[i]]);

            res = Math.max(res, i - pre);

            preIMap[cs[i]] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
