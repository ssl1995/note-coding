package 读书笔记.数据结构By慕课网.排序.selectionSort;


public class SelectionSort {
    private SelectionSort() {
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex );
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 选择排序1:从前到后选最小
    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 循环不变量：minIndex永远指向最小的元素
                minIndex = arr[minIndex].compareTo(arr[j]) < 0 ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }


    // 选择排序2从后到前选最大
    public static <E extends Comparable<E>> void selectionSort1(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                maxIndex = arr[j].compareTo(arr[maxIndex]) > 0 ? j : maxIndex;
            }
            swap(arr, i, maxIndex);
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
