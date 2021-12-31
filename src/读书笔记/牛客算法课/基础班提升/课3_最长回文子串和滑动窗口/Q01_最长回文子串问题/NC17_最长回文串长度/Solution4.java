package 读书笔记.牛客算法课.基础班提升.课3_最长回文子串和滑动窗口.Q01_最长回文子串问题.NC17_最长回文串长度;

public class Solution4 {
    // manachar法：求最长回文子串的长度
    public static int getLongestPalindrome(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        // 将s转换为加了特殊字符#的字符数组，目的是统一奇偶数的回文中心差异性问题
        // 比如：s=”cabac“转化为cs=[#c#a#b#a#c#]
        char[] cs = manacherString(A, n);
        // pArr[i]是cs[i]每个位置的最大回文半径
        // 比如：cs=[#c#a#b#a#c#]，pArr=[1,2,1,2,1,6,1,2,1,2,1]
        int[] pArr = new int[cs.length];
        // pR是cs[i]每个位置的回文右边界的下一个位置
        // 比如：cs=[#c#a#b#a#c#]，pR=1,3,3,5,5,11(此时pR第一次遍历完cs，之后的pR可以不再更新),11,11,11,11,11
        int pR = -1;
        // index是最近更新pR时的回文中心位置
        // 比如：cs=[#c#a#b#a#c#]，index=0,1,1,3,3,5(之后pR不再更新，index也不再更新),5,5,5,5,5
        int index = -1;
        // max记录pArr[i]中最大值：pArr[i]最大值就能算出最长回文子串长度
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i != cs.length; i++) {
            // 第一句代码:每轮循环时,i至少不需要验证的区域,先给到pArr[i],解释如下:
            // pR<=i:i超过了pR，无法优化，不用验证的区域就是pArr[i]本事=回文半径为1
            // pR>i:i没有超过pR，可以优化，至少不需要验的区域：Math.min(pArr[2 * index - i], pR - i)
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            // 第二句代码:在i位置尝试往外扩最长回文半径长度pArr[i]:
            // 如果扩成功pArr[i]++;否则立刻停止扩的过程break
            while (i + pArr[i] < cs.length && i - pArr[i] >= 0) {
                if (cs[i + pArr[i]] == cs[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 每轮循环,扩的长度超过回文右边界下一个位置，就更新pR和index
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            // 取pArr[i]中最大值
            maxLen = Math.max(maxLen, pArr[i]);
        }
        // 最长回文串长度是回文半径-1,比如#1#2#1#,2的最长回文半径是4,所以原始串121的长度是4-1=3
        return maxLen - 1;
    }

    // 将str转换成带#号的字符数组:解决奇数、偶数中心往外扩的差异性
    public static char[] manacherString(String s, int n) {
        char[] charArr = s.toCharArray();
        int index = 0;// index遍历charArr
        // s:a -> res:#a#，长度1 -> 3，奇数位放#，偶数位放原字符
        // s:ab -> res:#a#b#，长度2 -> 5，奇数位放#，偶数位放原字符
        // s:aba -> res:#a#b#a#，长度3 -> 7，奇数位放#，偶数位放原字符
        // 长度变化规律:len -> len+len+1=len*2+1，奇数位放#，偶数位放原字符
        char[] res = new char[n * 2 + 1];
        for (int i = 0; i != res.length; i++) {
            // 偶数位放#，奇数位放原字符
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
