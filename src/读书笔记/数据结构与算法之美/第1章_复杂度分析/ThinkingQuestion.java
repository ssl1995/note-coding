package 读书笔记.数据结构与算法之美.第1章_复杂度分析;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class ThinkingQuestion {
    private int N = 10;
    private int[] arr = new int[N];
    private int count = 0;

    /**
     * 摊还时间复杂度：O(1)、O(n)的出现频率是非常有规律的，有一定前后次序
     * 每一次O(n)的操作之后都接着一个n-1次O(1)的操作,把耗时长的均摊到耗时小的O(1)上，得出整体的时间复杂度为O(1)
     */
    private void add(int val) {
        if (count >= N) {
            int[] newArr = new int[2 * N];
            for (int i = 0; i < N; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            N = 2 * N;
        }
        arr[count] = val;
        count++;
    }
}
