package 剑指Offer.第三版.第6章_栈.q38_每日温度;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/7 9:34 上午
 * @description
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // 由于求时间差，所以栈中temperatures数组中下标
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            // 出栈原则：栈非空 且 当前元素值<栈顶下标对应的元素值
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈元素的下标和当前遍历的下标算时间差
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            // 入栈：入的是数组下标
            stack.push(i);
        }
        return res;
    }
}
