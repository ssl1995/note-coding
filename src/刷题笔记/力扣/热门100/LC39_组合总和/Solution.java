package 刷题笔记.力扣.热门100.LC39_组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/23 10:15 PM
 * @description
 */
public class Solution {
    /**
     * 组合总和：candidates无重复元素，但同一个数字可以重复使用
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        process(candidates, target, 0, temp, res);
        return res;
    }

    /**
     * 回溯
     *
     * @param nums   数组
     * @param target 目标值
     * @param i      坐标
     * @param temp   临时数组
     * @param res    二维结果集
     */
    private void process(int[] nums, int target, int i, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            // 注意：结果集加的是new list(temp)
            res.add(new LinkedList<>(temp));
        } else if (i <= nums.length - 1 && target > 0) {

            // 1.选择i位置加入：temp加入nums[i]，i指针不移动，target修改
            temp.add(nums[i]);
            process(nums, target - nums[i], i, temp, res);


            // 2.不选择i位置加入：i指针后移即可
            // i位置访问完毕，回溯返回之前状态
            temp.remove(temp.size() - 1);
            process(nums, target, i + 1, temp, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 5};
        int target = 8;
        System.out.println(solution.combinationSum(nums, target));
    }

}
