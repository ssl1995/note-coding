package 刷题笔记.力扣.热门100.LC448_找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/26 11:03 PM
 * @description
 */
public class Solution {
    /**
     * 找到所有数组中消失的数字
     * 其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        // 原地修改nums
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 原来数-1 = 数组下标
            int index = (nums[i] - 1) % n;
            // 由于数组元素[1,n]之间，原地修改后+n让不存在的数暴露
            nums[index] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 没有大于n的，都是缺失的数字
            if (nums[i] <= n) {
                // 下标数+1=原来数
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers(nums));
    }

}
