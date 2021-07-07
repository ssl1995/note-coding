package 程序员代码面试指南.第1章_栈和队列.用栈求解汉诺塔;


public class HanoiProblem1 {
    // 递归法
    public static int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        // 定义process函数，添加from、to函数
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right, String from, String to) {
        // 1.递归结束条件
        if (num == 1) {
            if (from.equals("mid") || to.equals("mid")) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        // 2.左到中||中到左||右到中||中到右
        if (from.equals("mid") || to.equals("mid")) {
            String another = (from.equals("left") | to.equals("left")) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, to, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, to, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
