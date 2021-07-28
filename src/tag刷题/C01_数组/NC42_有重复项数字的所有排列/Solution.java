package tag刷题.C01_数组.NC42_有重复项数字的所有排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    private boolean[] mark;// 标记该位置是否被选过

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        mark = new boolean[num.length];
        // 为了符合backtrack代码逻辑，将num进行排序
        Arrays.sort(num);
        backtrack(num, res, temp);
        return res;
    }

    private void backtrack(int[] num, ArrayList<ArrayList<Integer>> res, LinkedList<Integer> temp) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            // num含有重复项，并且已经排序过
            // A||B,A表示该数被用过，B表示是重复项且被使用重置过
            if (mark[i] || (i > 0 && num[i - 1] == num[i] && !mark[i - 1])) {
                continue;
            }
            temp.add(num[i]);
            mark[i] = true;
            backtrack(num, res, temp);
            // 将上一轮回溯返回的结果最后一个数移除
            temp.removeLast();
            mark[i] = false;
        }
    }

}
