package 剑指Offer.第二版.第5章_优化时间和空间效率.q41_数据流的中位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NC131 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);// 大根堆存较小的N/2个数
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 小根堆存较大的N/2个数


    public double[] flowmedian(int[][] operations) {
        ArrayList<Double> tempList = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1) {
                Insert(operations[i][1]);
            } else if (operations[i][0] == 2) {
                tempList.add(GetMedian());
            }
        }
        double[] res = new double[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    public void Insert(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyHeap();
    }

    public double GetMedian() {
        if (maxHeap.isEmpty()) {
            return -1.0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.00000;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    private void modifyHeap() {
        // 差距达到2才会发生调整
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        int[][] opt = {{1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}};
        NC131 solution = new NC131();
        double[] res = solution.flowmedian(opt);
        System.out.println(Arrays.toString(res));
    }
}
