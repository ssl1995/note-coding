package 学习笔记.面试学习.动态规划.C04_动态规划;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/29 10:56 AM
 * @Describe:
 */
public class MinCoin {

    /**
     * 硬币找零
     * 递归-备忘录-自底向上，解决判断子问题是否存在性能消耗
     */
    public static int getMinCoin1(int[] values, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        for (int v = 1; v < target + 1; v++) {
            // 模拟无穷大
            int minCount = target + 1;
            for (int value : values) {
                // 递归遍历所有的v，是比较v
                if (value > v) {
                    continue;
                }

                int restTarget = v - value;
                int restCount = memo[restTarget];

                if (restCount == -1) {
                    continue;
                }

                int curCount = restCount + 1;
                if (minCount > curCount) {
                    minCount = curCount;
                }
            }
            // 可用组合，记录结果
            if (minCount != target + 1) {
                memo[v] = minCount;
            }
        }

        return memo[target];
    }

    public static void main(String[] args) {
        int[] values = {3, 5};
        int target = 11;
        System.out.println(getMinCoin1(values, target));
    }
}
