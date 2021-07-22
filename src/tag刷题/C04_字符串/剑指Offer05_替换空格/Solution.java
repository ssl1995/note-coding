package tag刷题.C04_字符串.剑指Offer05_替换空格;

public class Solution {
    // 替换空格
    public String replaceSpace(String s) {
        // 单线程用StringBuilder更快
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
