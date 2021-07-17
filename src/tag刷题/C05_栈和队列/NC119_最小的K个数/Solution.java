package tag刷题.C05_栈和队列.NC119_最小的K个数;

import java.util.ArrayList;

public class Solution {

    // Q：最小的k个数
    // 注意：牛客这道题禁止使用jdk自带的PriorityQueue，并且牛客剑指offer40使用本题解法会提示超时，无法理解
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<Integer>();
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = input[i];
        }
        heapSort(temp);
        for (int i = k; i < input.length; i++) {
            if (temp[0] > input[i]) {
                temp[0] = input[i];
                heapSort(temp);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(temp[i]);
        }
        return res;
    }

    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // 建立大根堆，先将最小值
        minUp(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            minDown(arr, 0, i);
        }
    }


    private static void minUp(int[] arr) {
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            minDown(arr, parent, arr.length);
        }
    }

    private static void minDown(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            // left指向左右孩子最小值
            if (left + 1 < n && arr[left + 1] < arr[left]) {
                left++;
            }
            // 孩子中最小值>=父亲，
            if (arr[parent] <= arr[left]) {
                break;
            }
            swap(arr, parent, left);
            parent = left;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
