package 刷题笔记.力扣.热门100.LC5_最长回文子串;


public class Solution2 {
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
        for (int i = 0; i < len - 1; i++) {
            // 奇数中心的扩散长度
            int len1 = getPalindromeCenterLen(cs, len, i, i);
            // 偶数中心的扩散长度
            int len2 = getPalindromeCenterLen(cs, len, i, i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
                // 根据i和maxLen算begin下标
                // 奇数：i-maxLen/2
                // 偶数：i-maxLen/2+1
                // 统一：i-(maxLen-1)/2
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 返回cs中[i,j]位置往外扩的最大长度
     */
    private int getPalindromeCenterLen(char[] cs, int len, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            // 向外扩散，等于才扩散
            if (cs[i] == cs[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 循环跳出：cs[i]!=cs[j],如abc,cs[i]=a,cs[j]=c,回文中心长度为1
        // 此时的回文中心长度：j-i+1-2=j-i-1
        return j - i - 1;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "aba";
        System.out.println(solution2.getPalindromeCenterLen(s.toCharArray(), s.length(), 0, s.length() - 1));
    }
}
