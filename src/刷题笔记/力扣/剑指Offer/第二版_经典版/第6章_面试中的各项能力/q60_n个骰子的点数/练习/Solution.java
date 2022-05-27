package 刷题笔记.力扣.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q60_n个骰子的点数.练习;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/16 10:23 PM
 * @description
 */
public class Solution {

    public double[] dicesProbability(int n) {
        if (n == 0) {
            return new double[]{};
        }
        double[] res = new double[6];
        Arrays.fill(res, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] next = new double[5 * i + 1];
            for (int j = 0; j < res.length; j++) {
                for (int k = j; k < j + 6; k++) {
                    next[k] += res[j] / 6.0;
                }
            }
            res = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        System.out.println(Arrays.toString(solution.dicesProbability(n)));
    }
}
