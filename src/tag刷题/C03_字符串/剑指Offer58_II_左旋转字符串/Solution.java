package tag刷题.C03_字符串.剑指Offer58_II_左旋转字符串;

public class Solution {

    // 法1:使用String库函数subString()
    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));// [n,s.len]
        sb.append(s, 0, n);// [0,n]
        return sb.toString();
    }

    // 法2:取余法
    public String reverseLeftWords2(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        // 原s:[0,n-1,n,...,len-1]
        // 新sb:[n,...,len-1,len,...,n+len-1]
        for (int i = n; i < n + len; i++) {
            sb.append(s.charAt(i % len));
        }
        return sb.toString();
    }
}
