package 刷题笔记.力扣.代码随想录.C04_字符串.Q3_替换空格;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 4:45 PM
 * @Describe:
 */
public class Solution {
    /**
     * LC05 替换空格
     * 将空格替换为%20
     * 双指针法
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : cs) {
            if (c == ' ') {
                sb.append("  ");
            }
        }
        if (sb.length() == 0) {
            return s;
        }
        // left：原始字符串尾部
        int left = s.length() - 1;

        s += sb.toString();
        // right:扩充尾部后字符串尾部
        int right = s.length() - 1;

        cs = s.toCharArray();
        while (left >= 0) {
            if (cs[left] == ' ') {
                cs[right] = '0';
                cs[right - 1] = '2';
                cs[right - 2] = '%';
                right -= 2;
            } else {
                cs[right] = cs[left];
            }
            left--;
            right--;
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "We are happy.";
        System.out.println(solution.replaceSpace(s));
    }

}
