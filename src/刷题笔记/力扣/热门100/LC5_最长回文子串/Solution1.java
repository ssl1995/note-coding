package 刷题笔记.力扣.热门100.LC5_最长回文子串;


public class Solution1 {

    /**
     * 最长回文子串
     * 返回一个字符串的最长回文子串
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        // 暴力破解：最后一个字符没必要枚举了
        for (int i = 0; i < len - 1; i++) {
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

    /**
     * 判断cs的[i,j]位置之间是不是回文串
     */
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

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
