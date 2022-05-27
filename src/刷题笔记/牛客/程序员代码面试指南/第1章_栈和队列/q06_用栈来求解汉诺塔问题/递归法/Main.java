package 刷题笔记.牛客.程序员代码面试指南.第1章_栈和队列.q06_用栈来求解汉诺塔问题.递归法;

import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/1/9 10:03 PM
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int steps = hanoiProblem(num, "left", "mid", "right");
        System.out.println("It will move " + steps + " steps.");
    }

    public static final String MID = "mid";

    /**
     * 修改汉诺塔，必须经过中间盘子
     * 递归法
     */
    public static int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        // 只有1个盘子
        if (num == 1) {
            if (left.equals(MID) || right.equals(MID)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + MID);
                System.out.println("Move 1 from " + MID + " to " + to);
                return 2;
            }
        }
        // 非1个盘子
        // 起点或终点有中间盘子，需要3步
        if (left.equals(MID) || right.equals(MID)) {
            String anther = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, anther);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, anther, to);
            return part1 + part2 + part3;
        }
        // 起点或终点无中间盘子，可假设从左到右，需要5步
        int part1 = process(num - 1, left, mid, right, from, to);
        int part2 = 1;
        System.out.println("Move " + num + " from " + from + " to " + mid);
        int part3 = process(num - 1, left, mid, right, to, from);
        int part4 = 1;
        System.out.println("Move " + num + " from " + mid + " to " + to);
        int part5 = process(num - 1, left, mid, right, from, to);
        return part1 + part2 + part3 + part4 + part5;
    }


}
