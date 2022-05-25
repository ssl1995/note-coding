package 刷题笔记.力扣.代码随想录.C03_哈希表.Q8_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/09 10:20 AM
 * @Describe:
 */
public class Solution {
    /**
     * LC15 三数之和
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 注意：1.结果数组是元素值，不是两数之和的索引；2.结果是去重的
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 结果数组是元素值，联想到使用双指针->排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 固定i位置的数

            // i位置的数如果已经>0，因为数组已排序，后面的数无需遍历，直接break
            if (nums[i] > 0) {
                break;
            }
            // 去重：i从第1个数后，和前面的数相同的话，就不用再判断了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //  去重：left和right需要去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }

            }

        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -1, -1, 0};
        System.out.println(solution.threeSum(nums));
    }
}
