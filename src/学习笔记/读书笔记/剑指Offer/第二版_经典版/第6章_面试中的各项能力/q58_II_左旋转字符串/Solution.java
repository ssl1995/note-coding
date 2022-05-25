package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q58_II_左旋转字符串;

public class Solution {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     */
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        // 原s:下标0,n-1,n,...,len-1
        // 新sb:下标n,...,len-1,len,...,n+len-1
        for (int i = n; i < n + len; i++) {
            sb.append(s.charAt(i % len));
        }
        return sb.toString();
    }
}
