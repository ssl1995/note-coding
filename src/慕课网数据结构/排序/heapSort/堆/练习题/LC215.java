package 慕课网数据结构.排序.heapSort.堆.练习题;


import java.util.PriorityQueue;
import java.util.Queue;

public class LC215 {

    // 方法1:手写大根堆
    public int findKthLargest1(int[] nums, int k) {
        buildMaxHeap(nums);
        // 数组首位交换k次,数组首位就是第K大的数
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums[0];
    }


    // 建立大根堆
    private static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    // 对 arr[0, n) 所形成的最大堆中，索引为parent的父节点元素，进行heapify操作
    private static void heapify(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left] < arr[left + 1]) {
                left++;
            }
            // 大根堆,父最大,就停止遍历
            if (arr[left] <= arr[parent]) {
                break;
            }
            // 否则就最大值交换到父节点
            swap(arr, parent, left);
            // 父节点循环进行下去
            parent = left;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 方法2:使用PriorityQueue大根堆
    public int findKthLargest2(int[] nums, int k) {
        // 优先级队列默认是小根堆,拉姆达表达式改成大根堆
        Queue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxQueue.add(num);
        }
        // 第1大的数,第2大的数,第K大的数
        // 移0次     移1次    移K-1次
        for (int i = 0; i < k - 1; i++) {
            maxQueue.remove();
        }
        return maxQueue.peek();
    }

    // 方法2:PriorityQueue小根堆
    public int findKthLargest3(int[] nums, int k) {
        // 因为第k大元素是k个元素中最小的,所以用小根堆
        Queue<Integer> minQueue = new PriorityQueue<>();
        // 先将数组前k个数放入小根堆
        for (int i = 0; i < k; i++) {
            minQueue.add(nums[i]);
        }
        // [1,2,3,4]中第2大的数是3,[1,2]的小根堆顶是2,比下一个数3小所以出队
        // 因为排序后的后k个数虽然是这k个数中最小的,但确实非k个数中最大的,所以小根堆堆顶小了就要出队再入当前元素
        for (int i = k; i < nums.length; i++) {
            if (!minQueue.isEmpty() && minQueue.peek() < nums[i]) {
                minQueue.remove();
                minQueue.add(nums[i]);
            }
        }
        // 此时小根堆堆顶,就是第K大的元素
        return minQueue.peek();
    }

    // 法4:选择排序法
    public int findKthLargest4(int[] nums, int k) {
        // 外层循环k次
        for (int i = 0; i < k; i++) {
            // 找最大值就行
            int maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                maxIndex = nums[maxIndex] < nums[j] ? j : maxIndex;
            }
            swap(nums, i, maxIndex);
        }
        // 第一次最大值下标=1-1=0;
        // 第K次最大值下标=k-1
        return nums[k - 1];
    }
}
