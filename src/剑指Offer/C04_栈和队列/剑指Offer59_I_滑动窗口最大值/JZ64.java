package 剑指Offer.C04_栈和队列.剑指Offer59_I_滑动窗口最大值;

import java.util.ArrayList;
import java.util.LinkedList;

public class JZ64 {

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
}
