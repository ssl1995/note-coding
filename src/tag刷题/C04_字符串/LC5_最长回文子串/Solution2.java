package tag刷题.C04_字符串.LC5_最长回文子串;


public class Solution2 {
    // 动态规划法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int len1 = getPalindromeCenterLen(cs, len, i, i);// 奇数中心的扩散长度
            int len2 = getPalindromeCenterLen(cs, len, i, i + 1);// 偶数中心的扩散长度
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

    private int getPalindromeCenterLen(char[] cs, int len, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (cs[i] == cs[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 循环跳出：cs[i]!=cs[j]
        // 此时的回文中心长度：j-i+1-2=j-i-1
        return j - i - 1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = "abc1234321ab";
        System.out.println(solution.longestPalindrome(s));// 1234321
    }


}
