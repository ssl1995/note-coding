package 程序员代码面试指南.第1章_栈和队列.最大值减去最小值不大于num的子数组数;

import java.util.LinkedList;

public class GetNum {
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int i = 0, j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                if (qMin.isEmpty() || qMin.peekLast() != j) {
                    while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]) {
                        qMin.pollLast();
                    }
                    qMin.add(j);
                    while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]) {
                        qMax.pollLast();
                    }
                    qMax.add(j);
                }
                if (qMax.peekFirst() - qMin.peekFirst() > num) {
                    break;
                }
                j++;
            }
            // j++以后跳出循环，所以不用+1,直接j-i就行
            res += j - i;
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }
            i++;
        }
        return res;
    }
}
