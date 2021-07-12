package 牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    // Q:算会议室最多安排的个数
    // 贪心策略:找局部最优解,假设结束时间早于下一个项目的开始时间,这个项目就可以安排！
    // 怎么证明？对数器+必定正确的暴力解法来验证
    public static int bestArrange(Program[] programs, int timePoint) {
        // Arrays.sort(programs, new programsComparator());
        // Arrays.sort(programs, (o1, o2) -> o1.end-o2.end);
        Arrays.sort(programs, Comparator.comparingInt(o -> o.end));
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            // 时间点<=项目开始时间,说明项目还有时间开始,结果集+1
            if (timePoint <= programs[i].start) {
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }

    // 会议问题的开始时间和结束时间
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 比较器:以某个项目的结束时间早排序
    public static class programsComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

}
