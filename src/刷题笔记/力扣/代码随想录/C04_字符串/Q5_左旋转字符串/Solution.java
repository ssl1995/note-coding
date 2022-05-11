package 刷题笔记.力扣.代码随想录.C04_字符串.Q5_左旋转字符串;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 4:45 PM
 * @Describe:
 */
public class Solution {
    /**
     * 剑指Offer58II:左旋转字符串
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 提高难度：只能原地修改，不能申请额外空间
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        // 1.反转前n个字符
        reverserStr(sb, 0, n - 1);
        // 2.反转后面字符
        reverserStr(sb, n, s.length() - 1);
        // 3.反转整个字符串
        reverserStr(sb, 0, s.length() - 1);

        return sb.toString();
    }

    private void reverserStr(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcdefg";
        int k = 2;
        System.out.println(solution.reverseLeftWords(s, k));
    }

}
