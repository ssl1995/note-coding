package 牛客算法课.初级班.课7_图的遍历和最小生成树;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    // 会议问题的开始时间和结束时间
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        // 贪心策略：按照结束时间排序就能得到最优解，怎么证明？对数器+必定正确的暴力解法来验证
        Arrays.sort(programs, Comparator.comparingInt(o -> (o.end)));
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            // 当期时间早于某个项目的开始时间，结果集+1
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

}
