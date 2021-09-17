package 牛客.刷题.NC37_区间合并;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // ArrayList本身实现了sort方式，按照开始时间进行排序
        intervals.sort((a, b) -> a.start - b.start);
        ArrayList<Interval> res = new ArrayList<>();
        int len = intervals.size();
        int i = 0;
        while (i < len) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            // 需要合并集合的开始时间不能超过当前区间的结束时间
            while (i + 1 < len && intervals.get(i + 1).start <= end) {
                end = intervals.get(i + 1).end;
                i++;
            }
            res.add(new Interval(start, end));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(10, 30);
        Interval i2 = new Interval(20, 60);
        Interval i3 = new Interval(80, 100);
        Interval i4 = new Interval(150, 180);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        ArrayList<Interval> res = solution.merge(intervals);
        System.out.println("debug");
    }
}
