package 慕课网数据结构.sqrt;

import java.util.Arrays;

// 求解区间最大值问题
public class MaxSQRT {
    private int[] data, blocks;
    private int N;
    private int B;
    private int Bn;

    public MaxSQRT(int[] nums) {
        // 元素总数
        N = nums.length;
        if (N == 0) {
            return;
        }
        // 每组元素个数x:求根号
        B = (int) Math.sqrt(N);
        // 组数
        Bn = N / B + (N % B > 0 ? 1 : 0);
        data = Arrays.copyOf(nums, N);
        // blocks中存储区间的最大值，初始化为整型最小值
        blocks = new int[Bn];
        Arrays.fill(blocks, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            // blocks放遍历到的数组最大值
            blocks[i / B] += Math.max(blocks[i / B], data[i]);
        }
    }

    public int sumRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N || x > y) {
            return 0;
        }
        int bStart = x / B, bEnd = y / B;
        // 初始化res为整型最小值
        int res = Integer.MIN_VALUE;
        // 同一组内
        if (bStart == bEnd) {
            for (int i = x; i <= y; i++) {
                res = Math.max(data[i], res);
            }
            return res;
        }
        // 不同组内
        // data[x, (bStart + 1) * B-1]求和
        for (int i = x; i < (bStart + 1) * B; i++) {
            res = Math.max(data[i], res);
        }
        for (int bIndex = bStart + 1; bIndex < bEnd; bIndex++) {
            res = Math.max(data[bIndex], res);
        }
        for (int i = bEnd * B; i <= y; i++) {
            res = Math.max(data[i], res);
        }
        return res;
    }

    public void update(int i, int val) {
        if (i < 0 || i >= N) {
            return;
        }
        int bIndex = i / B;
        data[i] = val;
        // 重新取消掉blocks的值，再遍历data求和
        blocks[bIndex] = Integer.MIN_VALUE;
        // 最后一组可能会越界,使用Math.min((bIndex + 1) * B, N)
        for (int j = bIndex * B; j < Math.min((bIndex + 1) * B, N); j++) {
            blocks[bIndex] = Math.max(blocks[bIndex], data[j]);
        }
    }
}
