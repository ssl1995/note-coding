package 牛客.算法课.基础班提升.课3_最长回文子串和滑动窗口.Q01_最长回文子串问题.NC17_最长回文串长度;

public class Solution1 {
    // 暴力破解法：求最长回文子串的长度
    public int getLongestPalindrome(String A, int n) {
        int len = A.length();
        if (len < 2) {
            return 1;
        }
        int maxLen = 1;
        char[] cs = A.toCharArray();
        for (int i = 0; i < len - 1; i++) {// 最后一个字符没必要枚举了
            for (int j = i + 1; j < len; j++) {
                // 最长回文串：长度>之前的max，且，是回文串
                if (j - i + 1 > maxLen && isPalindrome(cs, i, j)) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
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
