package 慕课网数据结构.排序.shellSort.leetcode506;

import java.util.Arrays;

public class Solution {

    // 排序法+二分查找排名
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] copy = new int[n];
        System.arraycopy(score, 0, copy, 0, n);
        // 对复制数组进行排序
        Arrays.sort(copy);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            // 数组长度 = 排名 + 排序数组索引
            // 排序数组索引使用库里的二分查找快速得到
            int rank = n - Arrays.binarySearch(copy, score[i]);
            switch (rank) {
                case 1:
                    res[i] = ("Gold Medal");
                    break;
                case 2:
                    res[i] = ("Silver Medal");
                    break;
                case 3:
                    res[i] = ("Bronze Medal");
                    break;
                default:
                    // 不是奖牌排名,就放入排名
                    res[i] = String.valueOf(rank);
            }
        }
        return res;
    }
}
