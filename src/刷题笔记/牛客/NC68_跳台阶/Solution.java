package 刷题笔记.牛客.NC68_跳台阶;

public class Solution {

    public int jumpFloor(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

}
