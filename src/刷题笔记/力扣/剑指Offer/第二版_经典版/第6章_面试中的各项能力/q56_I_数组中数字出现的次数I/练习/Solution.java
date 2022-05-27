package 刷题笔记.力扣.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q56_I_数组中数字出现的次数I.练习;

/**
 * @author SongShengLin
 * @date 2022/1/16 4:11 PM
 * @description
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int a = 0, b = 0;
        for (int num : nums) {
            a ^= num;
        }
        int right = a & (~a + 1);
        a = 0;
        for (int num : nums) {
            if ((num & right) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

}
