package 牛客算法课.基础班.课3_堆排序和桶排序.Q01_堆排序;


public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.从0位置开始向上建立大根堆,使得堆顶为数组最大值
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 2.交换堆顶元素和数组末尾元素,最大值来到最终位置
        int size = arr.length;// size:记录待堆排序的数组边界
        swap(arr, 0, --size);
        // 3.从0开始对剩下的所有元素进行下沉操作
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
