package 刷题笔记.力扣.剑指Offer.第二版.算法.搜索算法.q11_旋转数组的最小数字;

public class JZ6 {
    public int minNumberInRotateArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int target = arr[right];
            if (arr[mid] < target) {
                right = mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return arr[left];
    }
}
