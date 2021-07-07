package 程序员代码面试指南.第4章_递归和动态规划.汉诺塔问题;

public class Hanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            hanoi(n, "left", "mid", "right");
        }
    }

    private static void hanoi(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("Move from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, to, mid);
            hanoi(1, from, mid, to);
            hanoi(n - 1, mid, from, to);
        }

    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
