package 刷题笔记.力扣.热门100.LC76_最小覆盖子串;

/**
 * @author SongShengLin
 * @date 2022/1/28 8:33 AM
 * @description
 */
public class Solution {
    /**
     * 最小覆盖子串
     * 返回 s 中涵盖 t 所有字符的最小子串
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        // map记录cs2中字符出现的次数
        int[] map = new int[256];
        for (char c : cs2) {
            map[c]++;
        }

        int left = 0, right = 0;
        // match:cs2中待需要匹配的字符数量
        int match = cs2.length;
        String res = "";

        while (right < cs1.length) {
            // 匹配上，匹配数量-1
            // --map[cs1[right]]本身就对数组元素进行-1操作
            if (--map[cs1[right]] >= 0) {
                match--;
            }
            // 判断是否多匹配：已经匹配完成 且 存在匹配多余的字符，就需要移动左指针，待匹配数+1
            while (match == 0 && map[cs1[left]] < 0) {
                map[cs1[left]]++;
                left++;
            }
            // match=0
            if (match == 0) {
                if ("".equals(res) || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }

            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
