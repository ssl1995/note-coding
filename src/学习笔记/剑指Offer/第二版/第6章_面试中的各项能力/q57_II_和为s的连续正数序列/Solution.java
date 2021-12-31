package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 输入一个正整数 `target` ，输出所有和为 `target` 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列.1 <= target <= 10^5
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     */
    public int[][] findContinuousSequence(int target) {
        int small = 1, big = 2;
        // 由于至少要有2个数，small作为起点的上界是不到(target+1)/2
        int mid = (target + 1) / 2;
        int curSum = small + big;
        List<int[]> res = new ArrayList<>();
        while (small < mid) {
            if (curSum == target) {
                listAddData(small, big, res);
            }
            while (curSum > target && small < mid) {
                // 在前一个和的基础上进行操作，减少不必要的计算
                curSum -= small;
                small++;
                if (curSum == target) {
                    listAddData(small, big, res);
                }
            }

            big++;
            curSum += big;

        }
        // list转化为二维数组返回
        return res.toArray(new int[0][]);
    }

    /**
     * list中添加[small,big]的数组
     */
    private void listAddData(int small, int big, List<int[]> list) {
        int[] temp = new int[big - small + 1];
        for (int i = small; i <= big; i++) {
            temp[i - small] = i;
        }
        list.add(temp);
    }
}
