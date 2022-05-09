package 刷题笔记.力扣.代码随想录.C04_字符串.Q1_反转字符串;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 4:45 PM
 * @Describe:
 */
public class Solution {
    /**
     * LC344 反转字符串
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
