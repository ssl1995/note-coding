package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第7章_队列.q42_最近请求次数;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/8 9:08 上午
 * @description
 */
public class RecentCounter {

    private Queue<Integer> queue;
    private int size;

    public RecentCounter() {
        queue = new LinkedList<>();
        // 题目要求窗口长度=3000
        size = 3000;
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - size) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        // peek=1才是头部
        System.out.println(queue.peek());
    }
}
