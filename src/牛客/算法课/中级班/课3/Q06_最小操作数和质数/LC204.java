package 牛客.算法课.中级班.课3.Q06_最小操作数和质数;

import java.util.Arrays;

public class LC204 {
    // 判断[0,n]内的质数数量
    // 筛选法
    public int countPrimes(int n) {
        // 创建长度为n的布尔数组
        boolean[] isPrime = new boolean[n];
        // 初始化所有数为true代表默认每个数都是质数
        Arrays.fill(isPrime, true);
        // 从[2,sqrt(n)]更新质数表
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {// 如果当前位置是质数，那么它的倍数位置肯定是合数
                    isPrime[j] = false;
                }
            }
        }
        // 从[2,n]统计质数，因为规定0和1都不是质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
