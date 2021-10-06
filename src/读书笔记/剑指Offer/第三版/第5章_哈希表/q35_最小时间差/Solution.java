package 读书笔记.剑指Offer.第三版.第5章_哈希表.q35_最小时间差;

import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/10/6 12:29 下午
 * @description
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        // 1天的时间的总分钟数:24*60
        // 如果时间点个数超过一天总的分钟数，必定有两个时间重叠，返回时间差为0
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        boolean[] minuteFlags = new boolean[24 * 60];
        for (String dateTime : timePoints) {
            String[] time = dateTime.split(":");
            int index = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            // 如果中间有重复的两个时间重叠，返回时间差为0
            if (minuteFlags[index]) {
                return 0;
            }
            minuteFlags[index] = true;
        }
        return helper(minuteFlags);
    }

    /**
     * 获取minuteFlags中最小的时间差值
     */
    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int first = minuteFlags.length - 1;
        int last = -1;
        int prev = -1;

        for (int i = 0; i < minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    // 统计非首尾的最小差值
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        // 还要计算首尾的最小差值
        minDiff = Math.min(minDiff, first + minuteFlags.length - last);
        return minDiff;
    }
}
