package 学习笔记.极客时间.数据结构与算法之美.第5章_树;

/**
 * @author SongShengLin
 * @date 2022/1/7 9:43 AM
 * @description
 */
public class PrintPermutations {

    public static void main(String[] args) {
        PrintPermutations solution = new PrintPermutations();
        int[] arr = {1, 2, 3};
        solution.printPermutations(arr, arr.length, arr.length);
    }

    /**
     * 打印数组的全排列,k是表示要处理的子数组的个数
     */
    public void printPermutations(int[] arr, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            // 依次确定最后一位
            int temp = arr[i];
            arr[i] = arr[k - 1];
            arr[k - 1] = temp;

            printPermutations(arr, n, k - 1);

            // 回溯，还原
            temp = arr[i];
            arr[i] = arr[k - 1];
            arr[k - 1] = temp;
        }

    }
}
