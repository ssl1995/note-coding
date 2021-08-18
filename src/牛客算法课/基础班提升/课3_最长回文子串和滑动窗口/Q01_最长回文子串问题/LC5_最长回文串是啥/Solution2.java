package 牛客算法课.基础班提升.课3_最长回文子串和滑动窗口.Q01_最长回文子串问题.LC5_最长回文串是啥;


public class Solution2 {
    // 中心扩散法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = getPalindromeCenterLen(cs, len, i, i);// 奇数中心的扩散长度,以(i,i)往两边扩
            int evenLen = getPalindromeCenterLen(cs, len, i, i + 1);// 偶数中心的扩散长度,以(i,i+1)往两边扩
            oddLen = Math.max(oddLen, evenLen);
            if (oddLen > maxLen) {// 超过max，就更新max和begin
                maxLen = oddLen;
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
                break;// i与j一旦不相等就循环停止
            }
        }
        // 循环跳出：cs[i]!=cs[j],如abc,cs[i]=a,cs[j]=c,回文中心长度为1
        // 此时的回文中心长度：j-i+1-2=j-i-1
        return j - i - 1;
    }
}
