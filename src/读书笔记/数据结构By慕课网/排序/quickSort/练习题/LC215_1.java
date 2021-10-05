
package 读书笔记.数据结构By慕课网.排序.quickSort.练习题;

import java.util.Random;

/**
 * @Author ssl
 * @Date 2020/12/5 13:35
 * @Description 215. 数组中的第K个最大元素
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class LC215_1 {
    // 使用快排的方法，但这个方法面试时候肯定是不推荐的，太难写了
    public int findKthLargest(int[] nums, int k) {
        // 将找出第K大的元素转换:求出第k小的元素 = nums.length-k
        Random random = new Random();
        // 递归法：return selectK(nums, 0, nums.length - 1, nums.length - k, random);
        // 以下是非递归法
        return selectK(nums, nums.length - k, random);
    }

    // 求出第k小的元素,递归法
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

    // 求出第k小的元素,非递归法
    private int selectK(int[] arr, int k, Random random) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int p = partition(arr, l, r, random);
            if (p == k) {
                return arr[p];
            } else if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        throw new RuntimeException("No Solution");
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
