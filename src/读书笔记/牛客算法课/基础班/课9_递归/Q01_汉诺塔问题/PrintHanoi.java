package 读书笔记.牛客算法课.基础班.课9_递归.Q01_汉诺塔问题;

public class PrintHanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
