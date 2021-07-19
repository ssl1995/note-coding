package tag刷题.C04_字符串.LC5_最长回文子串;


public class Solution1 {
    // Q:返回一个字符串的最长回文子串
    // 注意：牛客17题是求最长回文子串的长度，力扣是返回最长回文子串
    // 暴力破解
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {// 最后一个字符没必要枚举了
            for (int j = i + 1; j < len; j++) {
                // 最长回文串：长度>之前的max，且，是回文串
                if (j - i + 1 > maxLen && isPalindrome(cs, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean isPalindrome(char[] cs, int i, int j) {
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
