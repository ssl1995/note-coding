package 力扣.剑指Offer.第二版.剑指Offer58_I_反转单词顺序;


public class Solution {

    // 双指针法,倒序遍历字符串
    public String reverseWords(String s) {
        // 去掉首尾空格
        String trim = s.trim();
        int last = trim.length() - 1;// 每个非空单词的末尾指针
        int index = last;// 从后往前遍历字符串
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            // 获得每个非空单词的起始位置前一个位置
            while (index >= 0 && trim.charAt(index) != ' ') {
                index--;
            }
            // 添加：将这个单词添加进结果字符串中
            // 注意：还要加” “
            sb.append(trim, index + 1, last + 1).append(" ");
            // 去掉每个单词后的空格
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
