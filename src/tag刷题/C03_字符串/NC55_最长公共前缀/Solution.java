package tag刷题.C03_字符串.NC55_最长公共前缀;

public class Solution {

    // 题目:求一个字符数组的最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 注意:公共前缀是每一个字符串都共有的，也就是说从第一个字符串就有了
        // 初试化一个字符指向第一个字符串
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {// 从strs中第2个数开始遍历
            int index = 0;
            // 找到不相同的第一个index
            while (index < res.length() && index < strs[i].length()) {
                if (res.charAt(index) == strs[i].charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }
            // 截取(0,index)即为公共前缀
            res = res.substring(0, index);
            // 如果遇到公共前缀res是""时，整个函数直接返回""
            if ("".equals(res)) {
                return "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"abca", "abc", "abca", "abc", "abcc"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
