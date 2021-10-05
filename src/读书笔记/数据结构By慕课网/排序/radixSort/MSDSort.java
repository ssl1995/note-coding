package 读书笔记.数据结构By慕课网.排序.radixSort;

public class MSDSort {

    public static void mSDSort(String[] arr) {
        int N = arr.length;
        String[] temp = new String[N];
        mSDSort(arr, 0, N - 1, 0, temp);
    }

    /**
     * @param arr   待排序数组arr
     * @param left  对arr[i]待排序的最左边字符串
     * @param right 对arr[i]待排序的最右边字符串
     * @param r     arr[i]的r位置,处理arr[left, right]
     * @param temp  辅助数组一次性开辟出来
     */
    private static void mSDSort(String[] arr, int left, int right, int r, String[] temp) {
        // 递归结束条件
        if (left >= right) {
            return;
        }
        // 开始修改计数排序

        // 字符取值范围
        int R = 256;
        // 由于有null值,index和cnt数组比LSD都要加一位
        // 规定cnt[0]记录空值出现的次数
        int[] cnt = new int[R + 1];
        int[] index = new int[R + 2];

        // 记录arr[i]中r位置字符出现的次数
        for (int i = left; i <= right; i++) {
            // 越界:r位置如果超过了字符的长度=遇到了空值,规定了cnt[0]记录空值,所以cnt[0]++
            // 正常:cnt[arr[i].charAt(r) + 1]++
            cnt[r >= arr[i].length() ? 0 : (arr[i].charAt(r) + 1)]++;
        }
        // 记录次数
        for (int i = 0; i < cnt.length; i++) {
            index[i + 1] = index[i] + cnt[i];
        }
        // 赋值给temp数组
        for (int i = left; i <= right; i++) {
            int p = r >= arr[i].length() ? 0 : (arr[i].charAt(r) + 1);
            temp[left + index[p]] = arr[i];
            index[p]++;
        }
        // temp赋值回原数组
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        // 计数排序修改完成,开始递归,需要深刻理解
        for (int i = 0; i < R; i++) {
            mSDSort(arr, left + index[i], left + index[i + 1] - 1, r + 1, temp);
        }
    }

}
