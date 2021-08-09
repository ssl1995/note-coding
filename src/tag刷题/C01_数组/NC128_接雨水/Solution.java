package tag刷题.C01_数组.NC128_接雨水;


public class Solution {
    // 由数组arr(非负)组成的柱子能接多少单位的雨水？
    public long maxWater(int[] arr) {
        int left = 0, right = arr.length - 1, height = 0;
        long water = 0;// 水量根据返回值是long可知会超过int型
        while (left < right) {
            // 当前左右指针最小值
            int min = Math.min(arr[left], arr[right]);
            // 更新桶高：当前左右指针和桶高的最大值
            height = Math.max(height, min);
            // 雨水量 = 桶高-当前最矮
            water += arr[left] < arr[right] ? (height - arr[left++]) : (height - arr[right--]);
        }
        return water;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 2, 5, 2, 4};
        int[] arr1 = {4, 5, 1, 3, 2};
        System.out.println(solution.maxWater(arr));// 5
        System.out.println(solution.maxWater(arr1));// 2
    }
}
