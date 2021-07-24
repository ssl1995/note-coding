package tag刷题.C10_数学.剑指Offer57_II_和为s的连续正数序列;

import java.util.ArrayList;

public class JZ41 {
    // 生成目标数的连续正数序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int left = 1;// 左边界的值
        int right = 2;// 右边界的值
        int windowsLen = 3;// 整个左右窗口的值
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp;
        while (left < right) {// 左边界遇到右边界就停止
            // 如果本轮区间和为sum，就生成结果集
            if (windowsLen == sum) {
                temp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    temp.add(i);
                }
                res.add(temp);
            }
            // 再进行移动窗口判断
            if (windowsLen >= sum) {
                windowsLen -= left++;// 窗口值不小于目标值，扩大窗口值=left前移1位
            } else {
                windowsLen += ++right;// 窗口值大于目标值，缩小窗口值=right后移1位
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JZ41 jz41 = new JZ41();
        int sum = 9;
        System.out.println(jz41.FindContinuousSequence(sum));
    }
}
