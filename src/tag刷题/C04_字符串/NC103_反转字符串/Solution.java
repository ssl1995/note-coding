package tag刷题.C04_字符串.NC103_反转字符串;


public class Solution {

    // 反转字符串：不需要用栈，双指针原地交换即可
    public String solve(String str) {
        if (str == null) {
            return null;
        }
        char[] cs = str.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            swap(cs, i++, j--);
        }
        // 将cs数组转换为字符传，直接构造器即可，不需要StringBuffer
        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        if (i == j) {
            return;
        }
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        System.out.println(solution.solve(s));
    }
}
