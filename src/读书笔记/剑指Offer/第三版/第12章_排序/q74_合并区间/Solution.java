package 读书笔记.剑指Offer.第三版.第12章_排序.q74_合并区间;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/6 4:18 下午
 * @description
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        // 按起始位置从小到大排序
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};

            int j = i + 1;
            // 下一个数的起始时间<=上一个数的结束时间,就合并
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }

            merged.add(temp);
            i = j;
        }

        int[][] result = new int[merged.size()][2];
//        for (int j = 0; j < result.length; j++) {
//            result[j][0]=merged.get(j)[0];
//            result[j][1]=merged.get(j)[1];
//        }
//        return result;
        return merged.toArray(result);
    }
}
