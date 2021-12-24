package 剑指Offer.第二版.第5章_优化时间和空间效率.q48_最长无重复子串长度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] cs = s.toCharArray();
        // map<该字符,该字符上次出现的位置下标>,初始化value全为-1
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, -1);
        }
        // pre:str[i-1]为结尾的，无重复子串的起始位置的前一个位置,初试值为-1
        // 为什么是前一个位置，因为便于根据两个坐标计算长度
        int pre = -1;
        // 记录每一个字符结尾下的，无重复子串的最大长度
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            // 假设map.get(chars[i])=i‘,如果i‘在pre右边,说明[i’+1,i]一定是chars[i]结尾的无重复子串
            // pre和i‘谁在右边,更新谁=作为下一轮chars[i-1]的起始位置前一位
            if (map.get(cs[i]) >= pre) {
                pre = map.get(cs[i]);
            }
            // 如果i‘在pre左边,说明[pre+1,i]一定是chars[i]结尾的无重复子串
            res = Math.max(res, i - pre);
            // 更新map,记录元素与它最近出现的位置
            map.put(cs[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "aabcd";
        int len1 = solution.lengthOfLongestSubstring(str);
        System.out.println(len1);
    }
}
