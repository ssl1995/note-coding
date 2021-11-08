package 读书笔记.剑指Offer.第三版.第12章_排序.q76_数组中第K大的数字;

import java.util.Random;

/**
 * @author SongShengLin
 * @date 2021/11/8 9:16 上午
 * @description
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 第k大的数坐标为n-k，n是数组长度
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);

        while (index != target) {
            if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }

            index = partition(nums, left, right);
        }

        return nums[index];
    }

    // 分区，返回值一个坐标，该坐标左边比nums[right]小，右边比nums[right]大
    private int partition(int[] nums, int left, int right) {
        // 边界长度right-left+1,因为nextInt不能取到右边界，所以+1
        // 再加left是保证random属于[left,right]两边闭区间
        int random = new Random().nextInt(right - left + 1) + left;
        // 让基准是nums[right]
        swap(nums, random, right);

        // p1始终指向小于nums[right]的最后一个数
        int p1 = left - 1;
        for (int p2 = left; p2 < right; p2++) {
            if (nums[p2] < nums[right]) {
                p1++;
                swap(nums, p1, p2);
            }
        }
        // 最后p1再后移一位，与right交换
        p1++;
        swap(nums, p1, right);
        return p1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
