package 学习笔记.牛客算法课.基础班提升.课3_最长回文子串和滑动窗口.Q02_滑动窗口;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();// qmax维持队头是最大值下标
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // peekLast():数组末尾值
            // addLast():从数组末尾开始放元素=add()
            while (!qmax.isEmpty() && arr[i] >= arr[qmax.peekLast()]) {// 插入元素>=qax队尾下标对应的值，队尾就一直出
                qmax.pollLast();
            }
            qmax.addLast(i); // 队尾添加元素
            if (qmax.peekFirst() == i - w) {// 队头存的下标=i与w长度的前一个位置=过期失效，队头出队
                qmax.pollFirst();
            }
            if (i >= w - 1) {// i不小于窗口长度索引(w-1)，就res记录队头下标
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(getMaxWindow(arr, w)));// [5, 5, 5, 4, 6, 7]
    }

}
