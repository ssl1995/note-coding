package 剑指Offer.第二版.第6章_面试中的各项能力.q58_I_反转单词顺序;


public class Solution {

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public String reverseWords(String s) {
        // 去掉首尾空格
        String trim = s.trim();
        // 双指针
        // 每个非空单词的末尾指针
        int last = trim.length() - 1;
        // 从后往前遍历字符串
        int index = last;
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            // 获得每个非空单词的起始位置前一个位置
            while (index >= 0 && trim.charAt(index) != ' ') {
                index--;
            }
            // 添加：将这个单词添加进结果字符串中,同时加上空格
            sb.append(trim, index + 1, last + 1).append(" ");
            // 跳过原字符中单词中间的空格
            while (index >= 0 && trim.charAt(index) == ' ') {
                index--;
            }
            // 更新每个单词的末尾指针
            last = index;
        }
        // 返回结果去掉末尾的空格
        return sb.toString().trim();
    }
}
