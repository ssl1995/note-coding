package 刷题笔记.力扣.热门100.LC56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/26 11:08 PM
 * @description
 */
public class Solution {
    /**
     * 合并区间
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        // 将原数组按照左端点升序排序,变成:[[1,3],[2,6],[8,10],[15,18]]
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int last = res.size() - 1;
            // 不能合并区间:[8,10]、[15,18]
            if (res.isEmpty() || res.get(last)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                // 可以合并，取右端点最大值合并
                // [1,3]、[2,6],取右端点为6
                res.get(last)[1] = Math.max(res.get(last)[1], right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 4}, {0, 2}, {3, 5}};
        System.out.println(Arrays.deepToString(solution.merge(nums)));
    }
}
