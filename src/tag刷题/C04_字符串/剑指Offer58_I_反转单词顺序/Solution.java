package tag刷题.C04_字符串.剑指Offer58_I_反转单词顺序;


public class Solution {

    // 双指针法,倒序遍历字符串
    public String reverseWords(String s) {
        // 去掉首尾空格
        String trim = s.trim();
        int last = trim.length() - 1;
        // 倒序遍历,遍历指针初始化指向数组末尾
        int index = last;
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            // 找到第一个空格字符,它的下一位就是末尾单词
            while (index >= 0 && trim.charAt(index) != ' ') {
                index--;
            }
            // 将这个单词添加进结果字符串中
            sb.append(trim, index + 1, last + 1).append(" ");
            // 跳过相邻字符间的空格,来到下一个单词末尾
            while (index >= 0 && trim.charAt(index) == ' ') {
                index--;
            }
            // 末尾指针指向这个单词末尾
            last = index;
        }
        // 返回结果去掉首尾的空格
        return sb.toString().trim();
    }
}
