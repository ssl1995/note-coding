package 慕课网数据结构.排序.selectionSort.leetcode215;

public class Solution {

    // 选择排序法:找出K次最大值,返回即可
    public int findKthLargest(int[] nums, int k) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
