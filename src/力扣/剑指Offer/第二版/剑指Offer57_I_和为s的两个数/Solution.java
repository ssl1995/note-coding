package 力扣.剑指Offer.第二版.剑指Offer57_I_和为s的两个数;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 数组有序,sum<t时,说明nums[left]不够大,所有与当前left要匹配的right都构不成t
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }
}