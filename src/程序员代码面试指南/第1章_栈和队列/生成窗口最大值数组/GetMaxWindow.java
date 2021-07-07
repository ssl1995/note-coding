package 程序员代码面试指南.第1章_栈和队列.生成窗口最大值数组;

import java.util.Arrays;
import java.util.LinkedList;

// 力扣239
public class GetMaxWindow {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // qMax保存最大值下标
        LinkedList<Integer> qMax = new LinkedList<>();
        // res长度：n-w+1个窗口最大值
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 队中索引的值<=数组的值，就出队尾元素
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            // 队中索引的值>数组的值,就入队尾
            qMax.addLast(i);
            // 如果队头下标=i-w，说明队头下标已经过去，中间已有3个元素，弹出队头
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            // 从w-1索引开始，最大值需要加入结果集res中
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
