package 刷题笔记.力扣.热门100.LC739_每日温度;

import java.util.*;

public class Solution {

    /**
     * 每日温度
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return new int[]{};
        }
        int[] res = new int[temperatures.length];
        // 递减栈
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 栈非空 且 遍历的数比栈顶对应的数大
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈，得到第一个比遍历到的数小的数
                int index = stack.pop();
                // i-index就是两者距离，保存进结果
                res[index] = i - index;
            }
            // 进栈
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(t)));
    }
}