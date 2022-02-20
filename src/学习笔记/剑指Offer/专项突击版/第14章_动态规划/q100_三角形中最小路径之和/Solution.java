package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q100_三角形中最小路径之和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/22 8:49 下午
 * @description
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                // 先获得待加的数，同时i==0时也是初始化第一位
                dp[i][j] = triangle.get(i).get(j);
                // 第一列初始化
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][0];
                    // 对角线初始化
                } else if (i > 0 && i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    // 普通状态：min(左上角、正上角)
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // 最后一行找最小值，就是全员最小值
        for (int num : dp[size - 1]) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(2);
        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        List<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);

        List<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);

        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);

        Solution solution = new Solution();
        int res = solution.minimumTotal(triangle);

        System.out.println(res);
    }
}
