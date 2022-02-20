package 学习笔记.算法面试40讲.C13_哈希表.C14_有效的字母异位词.LC242_有效的字母异位词;

/**
 * @author SongShengLin
 * @date 2022/2/16 10:02 PM
 * @description
 */
public class Solution {

    /**
     * 有效的字母异位词
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[256];

        for (char c : s.toCharArray()) {
            if (map[c] != 0) {
                map[c]++;
            } else {
                map[c] = 1;
            }
        }

        for (char c : t.toCharArray()) {
            if (map[c] != 0) {
                map[c]--;
                if (map[c] < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab";
        String t = "a";
        System.out.println(solution.isAnagram(s, t));
    }
}
