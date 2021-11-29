package 剑指Offer.第二版.剑指Offer53_II_缺失的数字;

public class Solution {
    // 法:遍历数组
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
}
