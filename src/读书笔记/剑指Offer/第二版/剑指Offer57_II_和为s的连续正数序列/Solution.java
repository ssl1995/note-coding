package 读书笔记.剑指Offer.第二版.剑指Offer57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {
        // 初始化：窗口左右指针，窗口和
        int left = 1, right = 2, windowsSum = 3;
        // 根据示例，list中暂存int[]
        List<int[]> list = new ArrayList<>();
        while (left < right) {
            if (windowsSum < target) {// 窗口太小，右移指针再窗口值加大
                windowsSum += ++right;
            } else if (windowsSum > target) {// 窗口太大，窗口值减少再左移指针
                windowsSum -= left++;
            } else {// 窗口值等于目标值
                // 获取这一次的temp暂存进list中
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                list.add(temp);
                // 左移窗口
                windowsSum -= left++;
            }
        }
        // list转化为二维数组返回
        return list.toArray(new int[0][]);
    }
}
