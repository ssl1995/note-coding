package tag刷题.C01_数组.剑指Offer21_调整数组奇数位于偶数前面;

import java.util.Arrays;

public class Solution {

    // 双指针法,相对次序会发生改变
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 最中间的位置左右指针一旦越过,就又交换回去了,所以是left<right
        while (left < right) {
            // 循环里面嵌套循环,需要再次判断left<right
            // 左指针遍历到第一个非奇数的位置
            while (left < right && (nums[left] % 2) != 0) {
                left++;
            }
            // 右指针遍历到第一个非偶数的位置
            while (left < right && (nums[right] % 2) == 0) {
                right--;
            }
            // 交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }


    // 牛客：保持相对次序不变
    public int[] reOrderArray(int[] array) {
        int[] res = new int[array.length];
        int index = 0;
        // 先遍历奇数
        for (int num : array) {
            if (num % 2 != 0) {
                res[index++] = num;
            }
        }
        // 再遍历偶数
        for (int num : array) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(arr1)));
        System.out.println(Arrays.toString(solution.reOrderArray(arr2)));
    }

}
