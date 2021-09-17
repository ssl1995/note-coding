package 力扣.剑指Offer.第二版.剑指Offer45_把数组排成最小的数;


public class Solution {

    // 养成手写比较逻辑
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                // 如果字符串：x+y>y+x，则y在前
                if (num1 > num2) {
                    nums[i] = y;
                    nums[j] = x;
                }
                // 如果字符串：x+y<y+x，则x在前
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
