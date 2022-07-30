package 刷题笔记.牛客.程序员代码面试指南.练习.两个数的和;

import java.util.Scanner;

/**
 * @author SongShengLin
 * @date 2022/7/28 08:32
 * @description
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        getSum(a, b);

    }

    private static void getSum(int a, int b) {
        System.out.println(a + b);
    }

    public int add(int a, int b) {
        if ((a + b) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a + b;
    }
}
