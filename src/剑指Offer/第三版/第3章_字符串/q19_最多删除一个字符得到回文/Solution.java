package 剑指Offer.第三版.第3章_字符串.q19_最多删除一个字符得到回文;

public class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }
        // 1.start来到s一半位置，不用删除任何一个字符肯定是回文
        // 2.如果没有来到s一半位置，那么两种情况都要判断：(start+1,end)or(start,end-1)
        return start == s.length() / 2 || isValid(s, start + 1, end) || isValid(s, start, end - 1);
    }

    private boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }
}
