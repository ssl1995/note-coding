package 剑指Offer.第二版.剑指Offer57_II_和为s的连续正数序列;

import java.util.ArrayList;

public class JZ41 {
    // 生成目标数的连续正数序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int left = 1, right = 2, windowsSum = 3;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp;
        while (left < right) {// 左边界遇到右边界就停止
            // 统一移动写法的时候:必须先判断是否相同，再移动指针
            if (windowsSum == sum) {
                temp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    temp.add(i);
                }
                res.add(temp);
            }
            // 再进行移动窗口判断
            if (windowsSum >= sum) {
                windowsSum -= left++;// 窗口值不小于目标值，扩大窗口值=left前移1位
            } else {
                windowsSum += ++right;// 窗口值大于目标值，缩小窗口值=right后移1位
            }
        }
        return res;
    }
}
