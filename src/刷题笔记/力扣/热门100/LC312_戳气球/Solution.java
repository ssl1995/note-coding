package 刷题笔记.力扣.热门100.LC312_戳气球;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/24 12:30 AM
 * @description
 */
public class Solution {
    /**
     * 戳气球
     * 输入：nums = [3,1,5,8]
     * 输出：167
     * 解释：
     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        return dfs(list);
    }

    /**
     * 暴力递归
     */
    private int dfs(List<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        int n = arr.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = (i - 1 >= 0) ? arr.get(i - 1) : 1;
            int right = (i + 1 < n) ? arr.get(i + 1) : 1;
            int total = left * arr.get(i) * right;

            int remove = arr.remove(i);

            total += dfs(arr);

            res = Math.max(res, total);

            arr.add(i, remove);

        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums));
    }

}
