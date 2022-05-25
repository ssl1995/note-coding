package 刷题笔记.力扣.代码随想录.C04_字符串.Q4_反转字符串里的单词;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 4:45 PM
 * @Describe:
 */
public class Solution {
    /**
     * LC151 颠倒字符串中的单词
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 1.删除首位空格和中间多余的空格
        StringBuilder sb = clearSpace(s);
        // 2.反转整个s
        reverseStr(sb);
        // 3.反转单个单词
        reverseWord(sb);
        return sb.toString();
    }

    private StringBuilder clearSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 删除首尾的空格
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 中间有空格，只加一次;没有空格，直接加
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }

        return sb;
    }

    private void reverseStr(StringBuilder s) {
        reverseStr(s, 0, s.length() - 1);
    }

    private void reverseStr(StringBuilder s, int l, int r) {
        int left = l;
        int right = r;
        while (left <= right) {
            char c = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, c);
            left++;
            right--;
        }
    }

    private void reverseWord(StringBuilder s) {
        int left = 0;
        int right = 1;
        int n = s.length();
        while (left < n) {
            // 反转s中单个单词
            while (right < n && s.charAt(right) != ' ') {
                right++;
            }
            reverseStr(s, left, right - 1);

            left = right + 1;
            right = left + 1;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "the sky is blue";
        System.out.println(solution.reverseWords(s));
    }


}
