package 剑指Offer.第二版.第5章_优化时间和空间效率.q45_把数组排成最小的数;


public class Solution {

    /**
     * 把数组排成最小的数
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                // 由于xy、yx相加可能存在int移除问题
                // 我们将其转换为字符串，再用Long接受就没有int溢出问题
                long num1 = Long.parseLong(x + "" + y);
                long num2 = Long.parseLong(y + "" + x);
                // 12 < 21，则不用改
                // 21 > 12，说明要将y放在前面
                if (num1 > num2) {
                    nums[i] = y;
                    nums[j] = x;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
