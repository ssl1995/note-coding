package 刷题笔记.力扣.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q05_替换空格;

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
