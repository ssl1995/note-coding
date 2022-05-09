package 刷题笔记.力扣.代码随想录.C04_字符串.Q2_反转字符串II;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 4:45 PM
 * @Describe:
 */
public class Solution {

    /**
     * LC541 反转字符串II
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     */
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, n - 1);
            while (start < end) {
                swap(cs, start, end);
                start++;
                end--;
            }
        }
        return new String(cs);
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s ="abcdefg";
        int k = 2;
        System.out.println(solution.reverseStr(s, k));
    }

}
