package 读书笔记.数据结构By慕课网.排序.heapSort;

public class HeapSort1 {
    private HeapSort1() {

    }

    // 左神课上代码
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.从小到大排序，先转成大根堆，让数组第一位成数组最大值，便于与末尾交换
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 2.交换数组第一位和末尾，最大值放到数组末尾
        int size = arr.length;
        swap(arr, 0, --size);
        // 3.堆化排序
        while (size > 0) {
            heapIfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 数组转成大根堆
    private static void heapInsert(int[] arr, int i) {
        // 孩子节点大于父节点就交换
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // 堆化调整
    private static void heapIfy(int[] arr, int index, int size) {
        // 1.获取当前下标的左孩子索引
        int left = 2 * index + 1;
        // 2.while遍历，找到左右孩子中最大值与index交换
        while (left < size) {
            // 3.先找出左右孩子中最大值索引
            int largest = left + 1 < size &&
                    arr[left + 1] > arr[left] ? left + 1 : left;
            // 4.再找出左右孩子中最大值与arr[index]中最大值索引
            largest = arr[largest] > arr[index] ? largest : index;
            // 5.如果最大值还是当前索引，就停止堆化调整
            if (largest == index) {
                break;
            }
            // 6.找到最大值索引就交换
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
