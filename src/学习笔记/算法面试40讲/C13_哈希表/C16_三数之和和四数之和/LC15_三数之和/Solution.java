package 学习笔记.算法面试40讲.C13_哈希表.C16_三数之和和四数之和.LC15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/16 10:40 PM
 * @description
 */
public class Solution {

    /**
     * 三数之和
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // sort + find：将数组排序后查找
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        // 三数之和，需要两重循环
        // 第一重循环：固定数nums[i]
        for (int i = 0; i < n - 2; i++) {
            // 三数之和=0，如果排序后第一个数>0，必不存在
            if (nums[i] > 0) {
                return res;
            }
            // 排序后，i之前相同的数无需重复判断，需要去重
            // 注意：不能是i之后的相同的数去重，因为i之后的数可以相同判断三数之和
            // [-4,-1,-1,0,1,2]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 优化1
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 优化2
            if ((long) nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            // 第二重循环：找两个数
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
