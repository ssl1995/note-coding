package 刷题笔记.力扣.热门100.LC448_找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.Arrays;
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
        // 排序前:[4, 3, 2, 7, 8, 2, 3, 1]
        // 排序后:[1, 2, 2, 3, 3, 4, 7, 8]
        // 存在对应关系：num[i]-1=排序后下标
        // [5, 6]

        // 原地修改nums
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 数组元素[1,n]，nums[i]-1是它排序后出现的坐标
            // 由于之前可能已经+n，所以需要取模
            int index = (nums[i] - 1) % n;
            // nums[i]出现过，就让index坐标上+n，表示它出现过
            nums[index] += n;
        }

//        System.out.println("+n后的数组：" + Arrays.toString(nums));

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
        System.out.println("排序前:" + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(solution.findDisappearedNumbers(nums1));
    }

}
