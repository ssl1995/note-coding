package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q56_II_数组中数字出现的次数II;

/**
 * @author SongShengLin
 * @date 2021/12/27 11:12 PM
 * @description
 */
public class Solution {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     */
    public int singleNumber(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        // 统计每一位数的二进制位==1的和
        int[] bitSum = new int[32];
        for (int num : nums) {
            int bit = 1;
            // bit的末尾=数字的低位，开始遍历
            for (int j = 31; j >= 0; j--) {
                // !=0的，该位数+1
                if ((num & bit) != 0) {
                    bitSum[j] += 1;
                }
                // =0就不用加，更新bit
                bit = bit << 1;
            }
        }
        int res = 0;
        // res从高位到低位->bits的下标从小到大
        for (int i = 0; i < 32; i++) {
            // bit从高位开始判断，res从低位0开始左移
            res = res << 1;
            // 二进制res被强转成十进制 且 过滤掉出现次数为3的数
            res += bitSum[i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(solution.singleNumber(arr));

    }

}
