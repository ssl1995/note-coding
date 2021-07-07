package 程序员代码面试指南.第8章_数组和矩阵问题.最多会议室问题;

import java.util.Arrays;

public class BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] programs, int curTime) {
        // 1.将所有会议室，按照结束时间的从小到大排序
        Arrays.sort(programs, (o1, o2) -> (o1.end) - o2.end);
        int count = 0;
        // 2.遍历项目组，当前时刻<=项目的开始时间，就表示可以安排
        for (int i = 0; i < programs.length; i++) {
            if (curTime <= programs[i].start) {
                count++;
                curTime = programs[i].end;
            }
        }
        return count;
    }
}
