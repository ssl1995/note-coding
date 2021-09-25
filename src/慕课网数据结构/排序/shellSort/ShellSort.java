package 慕课网数据结构.排序.shellSort;


import java.util.Arrays;

public class ShellSort {
    private ShellSort() {
    }

    public static void shellSort(int[] arr) {
        // 步长step
        int step = arr.length / 2;
        // 插入排序最低就是步长为1
        while (step >= 1) {
            // 以step为距离进行插入排序
            for (int i = step; i < arr.length; i += step) {
                int temp = arr[i];
                int j;
                for (j = i; j - step >= 0 && temp < arr[j - step]; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step /= 2;
        }
    }


    // 希尔排序2:二重循环，背这个版本
    public static <E extends Comparable<E>> void shellSort2(E[] arr) {
        // 希尔的步长
        int step = arr.length / 2;
        while (step >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = step; i < arr.length; i++) {
                E temp = arr[i];
                int j;
                // 前一个元素是j-step
                for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step = step / 2;
        }
    }


    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序1：三重循环
    public static <E extends Comparable<E>> void shellSort1(E[] arr) {
        // 希尔的步长
        int step = arr.length / 2;
        while (step >= 1) {
            // start是每个子数组的起始位置
            for (int start = 0; start < step; start++) {
                // 以下是使用插入排序
                // 对每个子数组进行插入排序:data[start+step,start+2h...data.length-1]
                for (int i = start + step; i < arr.length; i += step) {
                    E temp = arr[i];
                    int j;
                    // 前一个元素是j-step
                    for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                        arr[j] = arr[j - step];
                    }
                    arr[j] = temp;
                }
            }
            step = step / 2;
        }
    }


    // 希尔排序3：修改步长序列
    public static <E extends Comparable<E>> void shellSort3(E[] arr) {
        // 希尔的步长
        int step = 1;
        while (step < arr.length) {
            step = step * 3 + 1;
        }
        while (step >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = step; i < arr.length; i++) {
                E temp = arr[i];
                int j;
                // 前一个元素是j-step
                for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step = step / 3;
        }
    }
}
