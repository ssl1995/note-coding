package tag刷题.C04_栈和队列.NC82_滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    // Q:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size > num.length || size < 1) {
            return new ArrayList<>();
        }
        // num=[2, 3, 4, 2, 6, 2, 5, 1]
        // res=[4, 4, 6, 6, 6, 5]
        // 双端队列队头存区间最大值
        LinkedList<Integer> qmax = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            // qmax弹出规则：qmax[尾]<=num[i]就弹出
            while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
                qmax.pollLast();
            }
            // qmax放入规则：qmax[尾]>num[i]才放
            qmax.addLast(i);
            // 过期出队：qmax队头下标是i-size，表示队头元素已过期，队头出队
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            // 开始记录：遍历指针超过窗口长度就记录返回值
            if (i >= size - 1) {
                res.add(num[qmax.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
/*        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(4);
        queue.addLast(3);
        queue.addLast(2);
        queue.addLast(1);
        System.out.println(queue);// [4, 3, 2, 1]
        System.out.println(queue.peekLast());// 1
        System.out.println(queue.peekFirst());// 4*/
        Solution solution = new Solution();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(num));
        int size = 3;
        ArrayList<Integer> res = solution.maxInWindows(num, size);
        System.out.println(res);// [4, 4, 6, 6, 6, 5]

    }
}
