package 读书笔记.数据结构By慕课网.排序.mergerSort;


import java.util.Arrays;


public class MergeSort2 {
    private MergeSort2() {
    }

    // 自底向上的归并排序：未使用插入排序
    public static <E extends Comparable<E>> void mergeSortBu(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // sz：遍历合并的区间长度,初始从一个区间的数组两两合并
        for (int sz = 1; sz < n; sz += sz) {
            // 合并[i,i+size-1]到[i+size,i+size+size-1]
            // i每次移动2个sz距离，才到下一个merge区间
            for (int i = 0; i + sz < n; i += (2 * sz)) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    // 注意：r是(i+2*sz-1,n-1)的最小值，因为不能越过数组末尾
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // 优化3：在mergesort之前就创建这个辅助数组，减少内存操作
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > r) {
                arr[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
    }

    // 自底向上的归并排序:使用插入排序优化，指定差距为16
    public static <E extends Comparable<E>> void mergeSortBu1(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // 遍历一遍，对所有arr[i, i + 15]的区间，使用插入排序法
        for (int i = 0; i < n; i += 16) {
            // 右边有可能越界，选择为最小值即可
            insertSort(arr, i, Math.min(i + 15, n - 1));
        }
        // sz：遍历合并的区间长度
        for (int sz = 16; sz < n; sz += sz) {
            // 合并[i,i+size-1]到[i+size,i+size+size-1]
            // i每次移动2个sz距离，才到下一个merge区间
            for (int i = 0; i + sz < n; i += (2 * sz)) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    // 注意：r是(i+2*sz-1,n-1)的最小值，因为不能越过数组末尾
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void insertSort(E[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            // 用temp存储当前变量
            E t = arr[i];
            int j;
            // t比前一个元素还小，j所在元素就后移一位
            for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            // t放入当前元素位置
            arr[j] = t;
        }
    }
}
