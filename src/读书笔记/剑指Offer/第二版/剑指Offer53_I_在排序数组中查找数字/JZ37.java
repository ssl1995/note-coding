package 读书笔记.剑指Offer.第二版.剑指Offer53_I_在排序数组中查找数字;

public class JZ37 {

    public int GetNumberOfK(int[] array, int k) {
        return rightBinarySearch(array, k) - rightBinarySearch(array, k - 1);
    }

    // 为了防止越界，返回等于目标值的最后一个坐标的下一个坐标
    private int rightBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 3, 3};
        JZ37 solution = new JZ37();
        System.out.println(solution.GetNumberOfK(arr1, 3));
    }
}
