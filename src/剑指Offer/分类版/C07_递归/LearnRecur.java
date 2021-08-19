package 剑指Offer.分类版.C07_递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnRecur {
    // 学习递归和分支感染问题的处理
    // 以nums[2,3,5]中找和为8的组合为例子学习
    public void combineRecur(int[] nums, int target) {
//        processSum1(new ArrayList<>(), nums, target);
        processSum2(new ArrayList<>(), nums, target);
        System.out.println("----");
        processSum3(new ArrayList<>(), nums, target);

    }

    // 递归：出现分支污染
    private void processSum1(List<Integer> list, int[] nums, int target) {
        if (target == 0) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        // 每个分支都要选择一下
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {// 比target大的分支就不要选择
                continue;
            }
            // 分支污染：list沿用之前分支的结果，这里就是错误的
            list.add(nums[i]);
            processSum1(list, nums, target - nums[i]);
        }
    }

    // 解法1：每次分支都新建一个temp，存之前的list
    private void processSum2(List<Integer> list, int[] nums, int target) {
        if (target == 0) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        // 每个分支都要选择一下
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {// 比target大的分支就不要选择
                continue;
            }
            // 每个分支都新建一个temp
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);
            processSum2(temp, nums, target - nums[i]);
        }
    }

    // 解法1：回溯，每次分支结束到新分支时，list就移除之前的存的记录
    private void processSum3(List<Integer> list, int[] nums, int target) {
        if (target == 0) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        // 每个分支都要选择一下
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {// 比target大的分支就不要选择
                continue;
            }
            list.add(nums[i]);
            processSum3(list, nums, target - nums[i]);
            // 回溯：递归函数下面，使用回溯移除之前存的数
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LearnRecur recur = new LearnRecur();
        int[] arr = {2, 3, 5};
        int target = 8;
        recur.combineRecur(arr, target);
    }

}
