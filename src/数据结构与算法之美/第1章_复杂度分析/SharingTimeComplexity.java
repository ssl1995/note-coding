package 数据结构与算法之美.第1章_复杂度分析;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class SharingTimeComplexity {
    private final int N = 10;
    private final int[] arr = new int[N];
    private int count = 0;

    /**
     * 时间复杂度：采用均摊时间复杂度的方法，本题的时间复杂度还是O(1)
     */
    private void insert(int val) {
        if (count == arr.length) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            System.out.println("sum:" + sum);
            count = 0;
        }
        arr[count] = val;
        count++;
    }
}
