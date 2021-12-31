package 学习笔记.牛客算法课.中级班.课1.Q02_苹果和牛羊吃草;

public class Eat {

    // 普通解
    public static String winner1(int n) {
        // base case:n<5
        // 	    n: 0  1  2  3  4
        // winner: 后 先 后  先 先
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        // n>=4，从1到n递归遍历先手是否能赢
        int base = 1;
        while (base <= n) {
            // n-base的后手就是当前base的先手
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {// 防止 base*4>n
                break;
            }
            base *= 4;
        }
        // 1到n先手不能赢，就返回后手
        return "后手";
    }

    // 最优解
    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        }
        return "先手";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " 赢家：" + winner1(i));
//            System.out.println(i + " 赢家：" + winner2(i));
        }
    }
}


