package 读书笔记.数据结构By慕课网.数组.练习题.剑指Offer;

/*
题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 */
public class Offer11 {
    /*
        学习二分查找的变种，旋转递增数组的某一段后，将pivot月与nums[r]比较
     */
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int pivot = l + (r - l) / 2;
            if (numbers[pivot] < numbers[r]) {
                r = pivot;
            } else if (numbers[pivot] > numbers[r]) {
                l = pivot + 1;
            } else {
                // 等于，右边位置移除一个位置
                r -= 1;
            }
        }
        return numbers[l];
    }
}
