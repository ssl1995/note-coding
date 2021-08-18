package 牛客.NC149_kmp算法;

public class Solution {

    // 牛客149kmp:给你一个非空模板串S是匹配串，一个文本串T是原串，问匹配串S在原串T中出现了多少次
    public int kmp(String S, String T) {
        if (T == null || S == null || S.length() < 1 || T.length() < S.length()) {
            return 0;
        }
        char[] s1 = T.toCharArray();
        char[] s2 = S.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(s2);// 改造1：next数组多算1位，记录整个匹配串的最长前后缀长度
        int res = 0;
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }// 以上是常规kmp
            if (i2 == s2.length) { // 改造2:i2到达s2.len,代表匹配上了,结果+1
                res++;
                i2 = next[i2];// i2再回退到整个s2的最长后缀位置开始二轮匹配
            }
        }
        return res;// 返回匹配个数
    }

    // 获得match串的改造next数组，比常规next多一位数，多出的末尾数组记录整个m的最长前后缀长度
    private int[] getNext(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length + 1];  // next改造1：next多算一个,多出的末尾数组记录整个ms的最长前后缀长度
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < match.length + 1) {  // next改造2：i < match.length + 1
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String S = "abab";
        String T = "abacabab";
        // 返回match子串在str中匹配的起始位置
        Solution solution = new Solution();
        System.out.println(solution.kmp(S, T));
    }
}
