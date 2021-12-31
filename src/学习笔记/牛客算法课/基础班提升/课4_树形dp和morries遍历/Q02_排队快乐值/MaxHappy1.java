package 学习笔记.牛客算法课.基础班提升.课4_树形dp和morries遍历.Q02_排队快乐值;

import java.util.List;

public class MaxHappy1 {

    public static class Employee {
        public int happy;// 这名员工能带来的快乐值
        public List<Employee> nexts;// 这名员工有哪些直接下级
    }

    // 法1:利用树形dp解
    public static int maxHappy(Employee boss) {
        ReturnType info = process(boss);
        return Math.max(info.laiMaxHappy, info.buMaxHappy);

    }

    private static class ReturnType {
        public int laiMaxHappy;// 父来的快乐最大值
        public int buMaxHappy;// 父不来的快乐最大值

        public ReturnType(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public static ReturnType process(Employee x) {
        // base case:x没有后续员工
        if (x.nexts.isEmpty()) {
            return new ReturnType(x.happy, 0);
        }
        int lai = x.happy;// x参与
        int bu = 0;// x不参与
        for (Employee next : x.nexts) {
            ReturnType nextInfo = process(next);
            // x参与:x快乐值+x下级不来的快乐值
            lai += nextInfo.buMaxHappy;
            // x不参与:0快乐值+x每个下级来or不来的整体快乐值的最大值
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new ReturnType(lai, bu);
    }

}
