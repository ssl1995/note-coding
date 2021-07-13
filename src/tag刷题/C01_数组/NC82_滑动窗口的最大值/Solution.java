package tag刷题.C01_数组.NC82_滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // Q:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size > num.length || size < 1) {
            return new ArrayList<Integer>() {
            };
        }
        // 双端队列存最大值下标,位置表头下标对应的元素最大
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            // 2.再次进元素时,双端队列维持队头保持最大值,从Last开始比较,维持窗口倒序排序
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            // 1.先进元素
            // addLast(x)从尾部添加元素x
            // add(index,x)在index存添加x
            // add(x)不写index的时候将指定元素e追加到此列表的末尾。与addLast（）用法相同
            queue.addLast(i);
            // 3.队头过期,就出队头
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            // 4.遍历指针超过窗口长度就记录返回值
            if (i >= size - 1) {
                res.add(num[queue.peekFirst()]);
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
