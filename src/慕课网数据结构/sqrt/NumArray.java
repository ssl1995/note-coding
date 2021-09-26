package 慕课网数据结构.sqrt;
import java.util.Arrays;

// 可以求解:力扣303、力扣307
public class NumArray {
    private int[] data, blocks;
    private int N;
    private int B;
    private int Bn;

    public NumArray(int[] nums) {
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
        blocks = new int[Bn];
        for (int i = 0; i < N; i++) {
            // 遍历原数组，将每块内元素值加入块内
            blocks[i / B] += nums[i];
        }
    }

    public int sumRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N || x > y) {
            return 0;
        }
        // 求出对应的组号
        int bStart = x / B, bEnd = y / B;
        int res = 0;
        // 同一组内
        if (bStart == bEnd) {
            for (int i = x; i <= y; i++) {
                res += data[i];
            }
            return res;
        }
        // 不同组内
        // data[x, (bStart + 1) * B-1]求和
        for (int i = x; i < (bStart + 1) * B; i++) {
            res += data[i];
        }
        // 求中间元素所处的组的元素之和
        for (int bIndex = bStart + 1; bIndex < bEnd; bIndex++) {
            res += blocks[bIndex];
        }
        // data[bEnd*B,y]求和
        for (int i = bEnd * B; i <= y; i++) {
            res += data[i];
        }
        return res;
    }
    public void update(int i, int val) {
        if (i < 0 || i >= N) {
            return;
        }
        // 求出i所处组号
        int bIndex = i / B;
        // 组内先减去待更新元素的值
        blocks[bIndex] -= data[i];
        // 再加上更新的值
        blocks[bIndex] += val;
        // 最后再更新
        data[i] = val;
    }
}
