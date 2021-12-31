package 读书笔记.剑指Offer.专项突击版.第3章_字符串.q18_有效的回文;

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1)) {
                i++;
            } else if (!Character.isLetterOrDigit(c2)) {
                j--;
            } else {
                c1 = Character.toLowerCase(c1);
                c2 = Character.toLowerCase(c2);
                if (c1 != c2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
