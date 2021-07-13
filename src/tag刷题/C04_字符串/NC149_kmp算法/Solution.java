package tag刷题.C04_字符串.NC149_kmp算法;

import java.util.Arrays;

public class Solution {
    // 牛客149kmp:给你一个非空模板串S，一个文本串T，问S在T中出现了多少次
    public int kmp(String S, String T) {
        if (T == null || S == null || S.length() < 1 || T.length() < S.length()) {
            return 0;
        }
        char[] s1 = T.toCharArray();
        char[] s2 = S.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(s2);
        int res = 0;
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
            // 以上是常规kmp算法,后续是改造了3点
            // 改造1:i2越界,代表匹配上了,结果+1
            // getNext中改造2:next多算一个,多出的末尾数组记录整个s2的最长前后缀长度
            if (i2 == s2.length) {
                res++;
                // i2再回退到整个s2的最长后缀位置开始二轮匹配
                i2 = next[i2];
            }
        }
        // 改造2:返回个数
        return res;
    }

    private int[] getNext(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        // 改造2-1:next多算一个,多出的末尾数组记录整个ms的最长前后缀长度
        int[] next = new int[ms.length + 1];
        next[0] = -1;
        next[1] = 0;
        int cur = 2;
        int cn = 0;
        // 改造2-2:由于next多算一个,遍历指针cur来到len+1才越界
        while (cur <= ms.length) {
            if (ms[cur - 1] == ms[cn]) {
                next[cur++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[cur++] = -1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String S = "abab";
        String T = "abacabab";
        // 返回match子串在str中匹配的起始位置
        Solution solution = new Solution();
        int[] next = solution.getNext(S.toCharArray());
        System.out.println(Arrays.toString(next));
        System.out.println(solution.kmp(S, T));
    }
}
