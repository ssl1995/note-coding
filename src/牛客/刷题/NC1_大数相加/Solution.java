package 牛客.刷题.NC1_大数相加;

public class Solution {

    public String solve(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1;// 从后往前遍历条件给的字符串
        int carry = 0;
        while (i >= 0 || j >= 0) {
            //  i < 0表示：高位补0；否则就按原值的int值计算
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
        // 最后结果记得反转返回
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "1";
        String s2 = "99";
        System.out.println(solution.solve(s1, s2));
    }
}
