package tag刷题.C01_数组.剑指Offer53_I_在排序数组中查找数字;

public class Solution {

    // 二分法:因为数组有序找target,思考用二分法
    public int search(int[] nums, int target) {
        // 问题：[5,7,7,8,8,10],t=8的出现的次数
        // 8的次数可以为10的下标-第一个8出现的下标
        // getRightMargin(nums, 8)返回大于8的第一个下标,就是10的下标
        // getRightMargin(nums, 7)返回大于7的第一个下标,就是第一个8的下标
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }

    // 修改二分法:让它返回>target的第一个数的下标
    private int getRightMargin(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 经验:二分法中<=就是返回t的右边界
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left <= right打破的时候，left来到>target的第一个数的下标
        return left;
    }
}
