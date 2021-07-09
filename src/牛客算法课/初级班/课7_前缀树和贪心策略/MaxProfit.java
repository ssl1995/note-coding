package 牛客算法课.初级班.课7_前缀树和贪心策略;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProfit {
    public static class Program {
        public int cost;
        public int profit;

        public Program(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    // W是初始资金，K是项目数量
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Program[] programs = new Program[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            programs[i] = new Program(Profits[i], Capital[i]);
        }
        PriorityQueue<Program> minCostQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        PriorityQueue<Program> maxProfitQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.profit));
        for (int i = 0; i < programs.length; i++) {
            minCostQueue.add(programs[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= W) {
                maxProfitQueue.add(minCostQueue.poll());
            }
            if (maxProfitQueue.isEmpty()) {
                return W;
            }
            W += maxProfitQueue.poll().profit;
        }
        return W;
    }

}
