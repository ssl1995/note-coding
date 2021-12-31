package 学习笔记.数据结构与算法之美.第1章_时间复杂度分析;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class ThinkingQuestion {
    private int Len = 10;
    private int[] arr = new int[Len];
    // 数组中已有的元素数量
    private int count = 0;

    /**
     * 摊还时间复杂度：O(1)、O(n)的出现频率是非常有规律的，有一定前后次序
     * 每一次O(n)的操作之后都接着一个n-1次O(1)的操作,把耗时长的均摊到耗时小的O(1)上，得出整体的时间复杂度为O(1)
     */
    private void add(int val) {
        if (count >= Len) {
            int[] newArr = new int[2 * Len];
            for (int i = 0; i < Len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            Len = 2 * Len;
        }
        arr[count] = val;
        count++;
    }
}
