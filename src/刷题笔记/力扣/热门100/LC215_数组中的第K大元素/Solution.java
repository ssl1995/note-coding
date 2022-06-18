package 刷题笔记.力扣.热门100.LC215_数组中的第K大元素;

import java.util.Random;

/**
 * @author SongShengLin
 * @date 2022/6/18 18:35
 * @description
 */
public class Solution {


    public int findKthLargest(int[] nums, int k) {
        int t = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);

        while (index != t) {
            if (index < t) {
                left = index + 1;
            } else {
                right = index - 1;
            }

            index = partition(nums, left, right);
        }

        return nums[index];
    }

    private int partition(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, random, right);

        int p1 = left - 1;
        int p2 = left;

        while (p2 < nums.length) {
            if (nums[p2] < nums[right]) {
                p1++;
                swap(nums, p1, p2);
            }
            p2++;
        }

        p1++;
        swap(nums, p1, right);
        return p1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
