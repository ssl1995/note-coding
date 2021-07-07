package 剑指Offer.剑指Offer53_II_缺失的数字;

public class Solution {
    // 法1:遍历数组
    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 情况1:数组元素与下标对应完整,比如:[0]返回1,[0,1]返回2,[0,1,2]返回3
            if (nums[i] == i && i == nums.length - 1) {
                return nums.length;
            }
            // 情况2:数组元素与下标对应不完整,比如:[0,1,3]返回2
            if (nums[i] != i) {
                return nums[i] - 1;
            }
        }
        return -1;
    }

    // 法2:nums[i] == i改成二分查找的写法
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // nums[i] == i改成nums[mid] == mid
            // 比如:[0,1]查找数字1,返回下标2;[0,1,3]查找数字1时,去右边[3]再查找
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                // nums[mid]!=mid,说明已经存在缺失数了,去左边界查找
                right = mid - 1;
            }
        }
        // 返回左指针
        return left;
    }
}
