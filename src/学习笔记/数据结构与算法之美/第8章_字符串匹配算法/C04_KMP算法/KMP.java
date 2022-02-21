package 学习笔记.数据结构与算法之美.第8章_字符串匹配算法.C04_KMP算法;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/2/21 8:43 AM
 * @description
 */
public class KMP {

    /**
     * kmp：返回a中匹配m的首个下标
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(kmp(str.toCharArray(), str.length(), match.toCharArray(), match.length()));
        // next数组：[-1, -1, 0, 1, 2]
        System.out.println("next数组：" + Arrays.toString(getNexts(match.toCharArray(), match.toCharArray().length)));

    }
}
