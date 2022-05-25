package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q57_II_和为s的连续正数序列.练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/16 7:52 PM
 * @description
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int small = 1, big = 2;
        int mid = (target + 1) / 2;
        int sum = small + big;
        List<int[]> temp = new ArrayList<>();
        while (small < mid) {
            if (sum == target) {
                addData(temp, small, big);
            }
            while (sum > target && small < mid) {
                sum -= small;
                small++;
                if (sum == target) {
                    addData(temp, small, big);
                }
            }
            big++;
            sum += big;
        }
        return temp.toArray(new int[temp.size()][]);
    }

    private void addData(List<int[]> list, int left, int right) {
        int[] nums = new int[right - left + 1];
        for (int i = 0; i < right - left + 1; i++) {
            nums[i] = i + left;
        }
        list.add(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.findContinuousSequence(9)));
    }
}
