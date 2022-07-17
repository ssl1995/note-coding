package 刷题笔记.力扣.剑指Offer.第二版.算法.位运算.q56_II_数组中数字出现的次数II.练习;

/**
 * @author SongShengLin
 * @date 2022/1/16 4:15 PM
 * @description
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] bits = new int[32];

        for (int num : nums) {
            int bit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((num & bit) != 0) {
                    bits[i]++;
                }
                bit <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            // 过滤掉出现3次的数
            res += bits[i] % 3;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 3, 3};
//        System.out.println(solution.singleNumber(nums));
        System.out.println((1 << 1) + 1);
    }
}
