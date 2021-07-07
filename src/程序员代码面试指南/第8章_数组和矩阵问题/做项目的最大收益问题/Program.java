package 程序员代码面试指南.第8章_数组和矩阵问题.做项目的最大收益问题;


import java.util.PriorityQueue;

// 与力扣502相同
public class Program {
    public int cost;
    public int profit;

    public Program(int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] costs) {
        if (k < 0 || w < 0 || profits == null || costs == null || profits.length != costs.length) {
            return w;
        }
        // 存放cost的最小值堆，指定比较器为cost从小到大排
        PriorityQueue<Program> heap1 = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 存放profit的最大值堆，指定比较器为profit从大到小排
        PriorityQueue<Program> heap2 = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        // 将数据放入最小值堆中，指定比较器为cost从小到大排
        for (int i = 0; i < costs.length; i++) {
            heap1.add(new Program(costs[i], profits[i]));
        }
        // 依次做K个项目
        for (int i = 1; i <= k; i++) {
            // 如果cost堆非空&&cost堆顶消费不大于启动资金，就加入profit堆
            // 记住:是根据流动的资金w来判断cost堆的
            while (!heap1.isEmpty() && heap1.peek().cost <= w) {
                heap2.add(heap1.poll());
            }
            // 如果profit堆为空，说明可以考虑的项目就为空，直接返回资金w
            if (heap2.isEmpty()) {
                return w;
            }
            w += heap2.poll().profit;
        }
        return w;
    }
}
