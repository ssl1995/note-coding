package 刷题笔记.力扣.代码随想录.C03_哈希表.Q2_有效的字母异位词;

/**
 * @author SongShengLin
 * @date 2022/3/20 19:17
 * @description
 */
public class Solution {
    /**
     * 有效的字母异位词
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        // 同组的异位词必须长度相同
        if (s.length() != t.length()) {
            return false;
        }

        int[] map = new int[128];
        // 扫描s，map++
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        // 扫描t，map--
        for (char c : t.toCharArray()) {
            if (map[c] <= 0) {
                // 失败情况
                // 如果哈希数组值小于0，说明t不匹配s
                return false;
            }
            map[c]--;
        }
        return true;
    }

}
