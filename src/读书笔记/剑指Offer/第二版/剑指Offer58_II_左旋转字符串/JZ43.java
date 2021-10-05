package 读书笔记.剑指Offer.第二版.剑指Offer58_II_左旋转字符串;

public class JZ43 {
    public String LeftRotateString(String str, int n) {
        if (str == null || "".equals(str)) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        // 原s:[0,n-1,n,...,len-1]
        // 新sb:[n,...,len-1,len,...,n+len-1]
        for (int i = n; i < n + len; i++) {
            sb.append(str.charAt(i % len));
        }
        return sb.toString();
    }
}
