package 剑指Offer.专项突击版.第7章_队列.q41_滑动窗口的平均值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/8 8:59 上午
 * @description
 */
public class MovingAverage {

    private Queue<Integer> queue;
    private int sum;
    private int cap;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        cap = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        // 如果队列长度超过cap，sum减一个数，队列移出头部元素
        if (queue.size() > cap) {
            sum -= queue.poll();
        }
        return (double) sum / queue.size();
    }
}
