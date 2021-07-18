package tag刷题.C04_字符串.NC17_最长回文子串;

public class Solution4 {
    // manachar法：求最长回文子串的长度
    public int getLongestPalindrome(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        // 将s转换为加了特殊字符#的字符数组:1212->#1#2#1#2#
        char[] str = manacherString(A, n);
        int[] pArr = new int[str.length];// 回文半径数组
        int R = -1;// 回文右边界的下一个位置=最大的有效区是R-1位置
        int C = -1;// 回文右边界中心点
        int max = Integer.MIN_VALUE;// 扩出来的最大值=最长回文子串的最大值
        for (int i = 0; i != str.length; i++) {
            // 第一句代码:每轮循环时,i至少不需要验证的区域,先给到pArr[i],解释如下:
            // 1.如果i在r内(包括边界),假设i‘=2*C-i,不需要验证的区域就是Math.min(pArr[i’],R-i)=
            //  四种情况不需要验证的区域:Math.min(pArr[i’],R-i)就这一句全部概括了
            // 2.如果i在r外,不需要验证的区域是它本身,返回-1.比如aba,第一个a的回文半径就是它本身,长度为1,不需要验证的区域是它
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            // 让i左右两边都往外扩,四种情况统一为往外扩:
            // 情况1、4是必须往外扩的,虽然情况2,3不需要往外扩,但是一旦往外扩肯定失败,所以可以统一代码
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 每轮循环,超过最大回文半径,就更新R和C
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            // 取pArr[i]中最大值
            max = Math.max(max, pArr[i]);
        }
        // 最长回文串长度是回文半径-1,比如#1#2#1#,2的最长回文半径是4,所以原始串121的长度是4-1=3
        return max - 1;
    }

    // 将str转换成带#号的字符数组
    public static char[] manacherString(String s, int n) {
        char[] charArr = s.toCharArray();
        int index = 0;// index遍历charArr
        // s:a -> res:#a#
        // s:aba -> res:#a#b#a#
        // 长度变化规律:len -> len+len+1=len*2+1
        char[] res = new char[n * 2 + 1];
        for (int i = 0; i != res.length; i++) {
            // 偶数位房放#，奇数位放原字符
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
