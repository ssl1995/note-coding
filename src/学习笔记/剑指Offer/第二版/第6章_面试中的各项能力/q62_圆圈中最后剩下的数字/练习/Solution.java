package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q62_圆圈中最后剩下的数字.练习;

/**
 * @author SongShengLin
 * @date 2022/1/17 9:03 AM
 * @description
 */
public class Solution {

    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5, m = 3;
        System.out.println(solution.lastRemaining(n, m));
    }
}
