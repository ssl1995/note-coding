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
        // 将原数组按照左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(num -> num[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            int last = res.size() - 1;
            // res不能合并当前[left,right],比如res=[1,6],[left,right]=[8,10]
            if (res.isEmpty() || res.get(last)[1] < left) {
                // 直接放入即可
                res.add(new int[]{left, right});
            } else {
                // res可以合并当前[left,right],比如res=[1,3]、[left,right]=[2,6]
                // 放入较大的右端点
                res.get(last)[1] = Math.max(res.get(last)[1], right);
            }
        }
        // 链表集合集转化为二维数组int[][]
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(solution.merge(nums)));
    }
}
