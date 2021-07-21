package tag刷题.C04_字符串.NC1_大数相加;

public class Solution {

    public String solve(String s, String t) {
        StringBuilder sb = new StringBuilder();
        // 从后往前遍历
        int i = s.length() - 1, j = t.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // while条件是 || ，所以需要判断i<0 or j<0的情况
            int a = i < 0 ? 0 : s.charAt(i--) - '0';
            int b = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = a + b + carry;// sum的值要继承上一轮的进位值carry
            sb.append(sum % 10);
            carry = sum / 10;
        }
        // 如果还要进位值，就再加到末尾
        if (carry == 1) {
            sb.append(carry);
        }
        // 因为是从后往前遍历s，t，相加结果要反转返回
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "1";
        String s2 = "99";
        System.out.println(solution.solve(s1, s2));
    }
}
