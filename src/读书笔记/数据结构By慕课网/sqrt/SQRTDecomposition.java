package 读书笔记.数据结构By慕课网.sqrt;

// 封装通用SQRT函数
public class SQRTDecomposition<E> {
    private E[] data, blocks; // data 和 blocks 都是 E 类型的数组
    private int N;  // 元素总数
    private int B;  // 每组元素个数
    private int Bn; // 组数
    private Merger<E> merger; // 合并函数 merger

    // 构造函数
    public SQRTDecomposition(E[] arr,Merger<E> merger) {
        this.merger = merger;

        N = data.length;
        if (N == 0) {
            return;
        }
        B = (int) Math.sqrt(N);
        Bn = N / B + (N % B > 0 ? 1 : 0);
        data = (E[]) new Object[N];
        for (int i = 0; i < N; i++) {
            data[i] = arr[i];
        }
        blocks = (E[]) new Object[Bn];
        for (int i = 0; i < N; i++) {
            // blocks[0]暂时=每个区间第一个元素
            if (i % B == 0)
                blocks[i / B] = data[i];
            else
                blocks[i / B] = merger.merge(blocks[i / B], data[i]);
        }

    }

    // 区间查询
    public E queryRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N || x > y) {
            return null;
        }
        int bStart = x / B, bEnd = y / B;
        // res 的初值是 data[x]
        E res = data[x];
        if (bStart == bEnd) {
            // 注意，从 x + 1 开始遍历
            for (int i = x + 1; i <= y; i++) {
                res = merger.merge(res, data[i]);
            }
            return res;
        }
        // 注意，从 x + 1 开始遍历
        for (int i = x + 1; i < (bStart + 1) * B; i++)
            res = merger.merge(res, data[i]);
        for (int b = bStart + 1; b < bEnd; b++)
            res = merger.merge(res, blocks[b]);
        for (int i = bEnd * B; i <= y; i++)
            res = merger.merge(res, data[i]);
        return res;
    }

    /// 单元素更新
    public void update(int index, E val) {

        if (index < 0 || index >= N) return;

        int b = index / B;
        data[index] = val;

        blocks[b] = data[b * B];
        for (int i = b * B + 1; i < Math.min((b + 1) * B, N); i++)
            blocks[b] = merger.merge(blocks[b], data[i]);
    }

}
