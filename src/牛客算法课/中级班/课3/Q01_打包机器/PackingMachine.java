package 牛客算法课.中级班.课3.Q01_打包机器;

public class PackingMachine {
    // Q:阿里原题，打包机器移动最少次数
    // 与力扣517：洗衣机问题相同
    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        // 一定失败：sum不能被机器数量整除
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int leftSum = 0;// arr[i]左边的物品总数量
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int L = i * avg - leftSum;// L:arr[i]左边物品应该有的数与当前累计和的差值
            int R = (n - i - 1) * avg - (sum - leftSum - arr[i]);// R:arr[i]右边物品应该有的数与当前累计和的差值
            // 业务规律1：L与R不相同,取两者绝对值较大的作为移动次数
            if (L > 0 && R > 0) {
                res = Math.max(res, Math.abs(L) + Math.abs(R));
            } else { // 业务规律1：L与R相同,取两者绝对值最大值的作为移动次数
                res = Math.max(res, Math.max(Math.abs(L), Math.abs(R)));
            }
            // 更新累加和
            leftSum += arr[i];
        }
        return res;
    }


}
