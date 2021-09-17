package 牛客.算法课.中级班.课3.Q06_最小操作数和质数;


public class SplitNbySM {

    // 附加题：怎么判断一个数是不是质数？
    // 暴力枚举法
    public static boolean isPrim(int n) {
        if (n < 2) {
            return false;
        }
        // 暴力枚举，为了降低时间复杂度，我们假设x,n/x是n的因数
        // 那么min(x,n/x)一定落在[2,sqrt(n)]内
        int max = (int) Math.sqrt((double) n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 请保证n不是质数
    // 返回:
    // 0) 所有因子的和，但是因子不包括1
    // 1) 所有因子的个数，但是因子不包括1
    public static int[] divsSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }


    public static int minOps(int n) {
        if (n < 2) {
            return 0;
        }
        // 如果n是质数，一直选择第二种操作就能获得最小操作次数
        if (isPrim(n)) {
            return n - 1;
        }
        // 如果n不是质数，就计算该n的所有质数之和和质数出现个数
        int[] divSumAndCount = divsSumAndCount(n);
        // 最小操作数 = 质数和-质数出现个数
        return divSumAndCount[0] - divSumAndCount[1];
    }


    public static void main(String[] args) {
        int n = 100;
        System.out.println(minOps(n));
    }
}
