package 慕课网数据结构.数组.练习题.剑指Offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 找出K个数：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 */
public class Offer40 {

    // 使用JDK的优先队列
    public int[] getLeastNumbers1(int[] arr, int k) {
        // 实现最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(11, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++)
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.remove();
        return res;
    }

    // 使用快速排序法
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Random random = new Random();
        // 第k小的元素是k前面的元素 = k-1，并且arr已经被排好序
        selectK(arr, 0, arr.length - 1, k - 1, random);
        return Arrays.copyOf(arr, k);
    }

    // 求出第k小的元素
    private int selectK(int[] arr, int l, int r, int k, Random random) {
        int p = partition(arr, l, r, random);
        if (p == k) {
            return arr[p];
        } else if (k < p) {
            return selectK(arr, l, p - 1, k, random);
        } else {
            return selectK(arr, p + 1, r, k, random);
        }
    }

    private int partition(int[] arr, int l, int r, Random random) {
        // 优化一：生成[l,r]的随机值，解决有序数组的问题
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 核心：arr[i+1...i-1] <= v ; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            while (i <= j && arr[j] > arr[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            // 循环判断完，交换i和j
            swap(arr, i, j);
            // 再次移动i和j
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
