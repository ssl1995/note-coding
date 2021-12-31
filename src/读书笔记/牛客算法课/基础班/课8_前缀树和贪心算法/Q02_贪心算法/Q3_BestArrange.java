package 读书笔记.牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.Arrays;

public class Q3_BestArrange {

    // Q:算会议室最多安排的个数
    public static int bestArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, (o1, o2) -> o1.end - o2.end);// 贪心：项目按照结束时间排序
        int result = 0;
        for (Program program : programs) {
            if (timePoint <= program.start) {  // 时间点<=项目开始时间,说明项目还有时间开始,结果集+1
                result++;
                timePoint = program.end;
            }
        }
        return result;
    }

    // Program数据结构：开始时间和结束时间
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Program p1 = new Program(8, 10);
        Program p2 = new Program(9, 11);
        Program p3 = new Program(11, 12);
        Program p4 = new Program(12, 13);
        Program[] arr = {p1, p2, p3, p4};
        int timePoint = 8;
        System.out.println(bestArrange(arr, timePoint));

    }
}
