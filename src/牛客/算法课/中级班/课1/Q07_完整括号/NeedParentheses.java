package 牛客.算法课.中级班.课1.Q07_完整括号;

public class NeedParentheses {

    public static int needParentheses(String str) {
        int count = 0;
        int needRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    needRight++;
                } else {
                    count--;
                }
            }
        }
        return count + needRight;
    }

}
