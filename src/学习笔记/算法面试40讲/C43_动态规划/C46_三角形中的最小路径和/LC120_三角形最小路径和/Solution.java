package 学习笔记.算法面试40讲.C43_动态规划.C46_三角形中的最小路径和.LC120_三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/20 9:04 AM
 * @description
 */
public class Solution {

    /**
     * 三角形最小路径和
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为11(2+3+5+1=11)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        // 思考自顶向下，贪心是失败的，原因的最底部可能是大数导致结果失败
        // 自底向上，从三角形最后一行往上找最小路径
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        // dp初始化为三角形最底层
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        // 从三角形倒数第二层开始动态规划
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // dp=Math.min(下一层相邻)+当前节点值
                dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
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
