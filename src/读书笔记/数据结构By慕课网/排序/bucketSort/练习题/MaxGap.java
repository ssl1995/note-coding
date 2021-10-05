package 读书笔记.数据结构By慕课网.排序.bucketSort.练习题;


public class MaxGap {

    // 力扣164题
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 1.统计数组长度,最大值,最小值
        int N = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // 如果最大值和最小值相同,最大间距为0,直接返回
        if (min == max) {
            return 0;
        }
        // 2.生成3个桶,每个桶长N+1
        boolean[] hasNum = new boolean[N + 1];
        int[] maxs = new int[N + 1];
        int[] mins = new int[N + 1];
        // 3.最大值桶只放区间最大值，最小值桶只放区间最小值
        // bid是桶id,记录放入桶的编号
        int bid = 0;
        // 有几个数就要遍历几次=遍历N次
        for (int i = 0; i < N; i++) {
            // 算出每个元素放入桶中的id
            bid = getBucketId(nums[i], N, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        // 4.排序后，相邻元素的最大差值=(当前非空桶最小值-上一个非空桶最大值)中的最大值
        int maxGap = 0;
        int lastMax = maxs[0];
        // 从第2个桶开始统计最大差值
        for (int i = 1; i <= N; i++) {
            if (hasNum[i]) {
                // 相邻元素的最大差值=(当前非空桶最小值-上一个非空桶最大值)中的最大值
                maxGap = Math.max(maxGap, mins[i] - lastMax);
                // 更新上一个非空桶的最大值
                lastMax = maxs[i];
            }
        }
        return maxGap;
    }

    // 计算num放入哪个桶:(arr[i]-min)/桶长,桶长=(max-min)/len
    // 注意:数据类型全部用long,因为有乘法int会溢出
    private int getBucketId(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
