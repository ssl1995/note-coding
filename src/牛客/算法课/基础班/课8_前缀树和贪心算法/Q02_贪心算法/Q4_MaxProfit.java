package 牛客.算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q4_MaxProfit {

    // Q:找利润最大值?
    // K是项目数量,W是初始资金,Profits项目利润,Capital项目花费
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 生成项目数组
        Program[] programs = new Program[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            programs[i] = new Program(Profits[i], Capital[i]);
        }
        // 小根堆存花费
        PriorityQueue<Program> min = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        // 大根堆存项目利润
        PriorityQueue<Program> max = new PriorityQueue<>(Comparator.comparingInt(o -> o.profit));
        // 往小根堆加入所有的项目
        for (int i = 0; i < programs.length; i++) {
            min.add(programs[i]);
        }
        // 遍历项目个数K
        for (int i = 0; i < k; i++) {
            // 小根堆不为空 且 小根堆堆顶(最小花费)<=起始资金
            while (!min.isEmpty() && min.peek().cost <= W) {
                // 大根堆就入该最小花费
                max.add(min.poll());
            }
            // 如果此时大根堆为空(再无项目利润),返回此时的利润W
            if (max.isEmpty()) {
                return W;
            }
            // 否则,利润W+=大根堆堆顶.profit
            W += max.poll().profit;
        }
        return W;
    }

    public static class Program {
        public int cost;// 花费
        public int profit;// 利润
        // 花费+利润 = 到手的钱

        public Program(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

}
