package 牛客.算法课.中级班.课1.Q01_绳子;

public class CordCoverMaxPoint {

    // 长度为L的绳子最多覆盖几个点，请保证arr有序
    // 法1：压左边界
    public static int maxPoint(int[] arr, int L) {
        int res = 1;// 绳子长L为正数，至少能压中1个点
        for (int i = 0; i < arr.length; i++) {
            int left = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    // 在arr[0..R]范围上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        // 从arr[R]开始看左边能压中那几个坐标，每次至少能压中arr[R],所以res=1
        int res = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 13, 24, 35, 46, 57, 60, 72, 87};
        int L = 6;
        System.out.println(maxPoint(arr, L));

    }

}
