package 读书笔记.剑指Offer.第三版.第12章_排序.q79_所有子集;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 8:56 上午
 * @description
 */
public class Solution {
    // 求一个数组中所有元素的子集，子集是不需要考虑顺序的，比如[1,2]的子集有[],[1],[2],[1,2]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        helper(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subList, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new LinkedList<>(subList));
        } else if (index < nums.length) {
            // 选择1：该子集不加任何数，直接到下一个数
            helper(nums, index + 1, subList, res);

            // 选择2：该子集加当前数，然后到下一个数
            subList.add(nums[index]);
            helper(nums, index + 1, subList, res);
            // 选择2：在子集处理完下一个数后，回溯到父节点时，清除对子集状态的修改
            subList.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2};

        System.out.println(solution.subsets(nums));
    }
}
