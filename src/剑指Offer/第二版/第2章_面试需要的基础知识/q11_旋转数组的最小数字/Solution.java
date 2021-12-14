package 剑指Offer.第二版.第2章_面试需要的基础知识.q11_旋转数组的最小数字;

public class Solution {
    /**
     * 获取旋转递增数组后的最小值
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 数组部分旋转,目标值改为数组最右边元素
            int target = numbers[right];
            if (numbers[mid] < target) {
                // 中间值<右边值 = 右边递增
                // 最小值在左边,取得到mid
                right = mid;
            } else if (numbers[mid] > target) {
                // 中间值>右边值 = 右边递减
                // 最小值在右边,取不到mid
                left = mid + 1;
            } else {
                // 中间值=右边值,无法判断在左边还是右边,但最小值一定靠近左边,缩小mid=缩小target=right--
                right--;
            }
        }
        // 返回值是left位置的数
        return numbers[left];
    }
}
