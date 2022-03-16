package 刷题笔记.力扣.热门100.LC34_在排序数组中查找第一个和最后一个位置;

/**
 * @author SongShengLin
 * @date 2021/12/26 6:15 PM
 * @description
 */
public class Solution {

    /**
     * 在排序数组中查找第一个和最后一个位置
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */
    public int[] searchRange(int[] nums, int target) {
        if (!isContainTarget(nums, target)) {
            return new int[]{-1, -1};
        }
        return new int[]{getNextTargetFirstIndex(nums, target - 1), getNextTargetFirstIndex(nums, target) - 1};
    }

    private boolean isContainTarget(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取>target的第一个数的下标
     */
    private int getNextTargetFirstIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 经验:二分法中<=就是返回t的右边界
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left <= right打破的时候，left来到>target的第一个数的下标
        return left;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr = {5, 7, 7, 8, 8, 10};
//        int t = 8;
//        System.out.println(Arrays.toString(solution.searchRange(arr, t)));
        String s = "华扬在给口碑网做计划，想做跨界的合作，看跟白领夜生活怎么进行结合。\n" +
                "我们梳理了相关的思路给到代理，具体如下：\n" +
                "1、联名脉脉发布针对职场人白领夜生活的深夜食堂数据报告\n" +
                "A、“白领深夜食堂大调查”与运营及新媒体协作发布问卷\n" +
                "通过脉脉微信两个公号文章、脉脉站内话题做前期预热\n" +
                " B、联合KOL例如衣二三创始人兼CEO、Mina米娜杂志主编杨扬、Binance联合创始人何一等职场女神发布报告。\n" +
                "2、通过数据报告透析发布联名白领夜生活消费TOP 10的口碑饭票\n" +
                "3、PR长尾传播：\n" +
                "例如：脉脉万人职场深夜生活调查：实力是通行证，颜值是敲门砖\n" +
                "今天再找些深夜食堂的种草案例给客户，保持跟进";
        s = s.replaceAll("\n", " ");
        System.out.println(s);
    }
}
