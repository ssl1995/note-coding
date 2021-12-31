package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q93_最长斐波那契数列;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/11/17 12:05 上午
 * @description
 */
public class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        // 前提条件：数组中至少有3个数字
        int len = arr.length;
        // map中存数字和其下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 是否存在坐标k，使得arr[i]=arr[j]+arr[k] => arr[k]=arr[i]-arr[j]
                int k = map.getOrDefault(arr[i] - arr[j], -1);

                // dp[i][j]表示i之前的j如果存在合法的k在j之前，使得arr[j]=arr[i]+k,则dp[i][j]=ap[j][k]+1
                dp[i][j] = k != -1 && k < j ? dp[j][k] + 1 : 2;

                res = Math.max(res, dp[i][j]);
            }
        }
        // 结果值必须>2，因为数组至少有3个数，至少形成3个有效的斐波那契，否则为0
        return res > 2 ? res : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 5};
        System.out.println(solution.lenLongestFibSubseq(arr));
    }

}
