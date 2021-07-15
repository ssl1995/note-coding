package 剑指Offer.正序版.正序版.剑指Offer03_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 法1:哈希表
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        throw new RuntimeException("Nums have not repeat num");
    }

    // 法2:数组下标与元素对应法
    public int findRepeatNumber2(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // 1.遍历指针移动条件:第一次索引与当前元素对应,后移指针,因为是第一次所以放在最前面
            if (nums[index] == index) {
                index++;
                continue;
            }
            // 2.比较当前元素与其对应下标的元素值
            if (nums[index] == nums[nums[index]]) {
                return nums[index];
            } else {
                swap(nums, index, nums[index]);
            }
        }
        throw new RuntimeException("Nums have not repeat num");
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
