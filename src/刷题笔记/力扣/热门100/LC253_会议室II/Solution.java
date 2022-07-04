package 刷题笔记.力扣.热门100.LC253_会议室II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SongShengLin
 * @date 2022/2/22 9:32 PM
 * @description
 */
public class Solution {
    /**
     * 会议室II
     * 输入：intervals = [[0,30],[5,10],[15,20]]
     * 输出：2
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照开始时间排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 最小堆加一个会议的结束时间，最小堆个数表示当前正在用的会议室数量
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // 上一个会议的结束时间<=待加入的会议的开始时间，表示会议室可复用
            if (minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            // 最小堆保存当前会议的结束时间
            minHeap.offer(intervals[i][1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.minMeetingRooms(nums));
    }
}
