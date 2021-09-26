package 慕课网数据结构.树.练习题.剑指Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
力扣386：给定一个整数 n, 返回从 1 到 n 的字典顺序。
给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9]
 */
public class LC386 {
    //暴力法:使用优先级队列，指定比较器String小的放前面
    public static List<Integer> lexicalOrder1(int n) {
        PriorityQueue<String> queue = new PriorityQueue<>(String::compareTo);
        for (int i = 1; i <= n; i++) {
            queue.add(String.valueOf(i));
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(Integer.valueOf(queue.poll()));
        }
        return res;
    }

}
