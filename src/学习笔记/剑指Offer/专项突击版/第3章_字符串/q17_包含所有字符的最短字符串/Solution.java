package 学习笔记.剑指Offer.专项突击版.第3章_字符串.q17_包含所有字符的最短字符串;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        // count表示出现在t中，但还没有出现在s中子字符串中字符个数
        int count = charToCount.size();
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            // count>0说明还有在t中出现，但s中子字符串没有出现的字符
            if (count > 0) {
                char endChar = s.charAt(end);
                if (charToCount.containsKey(endChar)) {
                    charToCount.put(endChar, charToCount.get(endChar) - 1);
                    if (charToCount.get(endChar) == 0) {// =0说明在t和s中出现次数相同
                        count--;
                    }
                }
                end++;
            } else {// count<=0，说明s子字符串中都出现了t
                // 更新左右指针
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startChar = s.charAt(start);
                if (charToCount.containsKey(startChar)) {
                    charToCount.put(startChar, charToCount.get(startChar) + 1);
                    if (charToCount.get(startChar) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLen < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADDBANCAD";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
