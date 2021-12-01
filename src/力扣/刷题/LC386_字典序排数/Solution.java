package 力扣.刷题.LC386_字典序排数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // 力扣386:字典序排数,给定一个整数 n, 返回从 1 到 n 的字典顺序。
    // 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9]

    // 递归解法
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {// 第一位数不能从0开始，1到9开始递归调用dfs
            dfs(res, num, n);
        }
        return res;
    }

    private void dfs(List<Integer> res, int cur, int n) {
        // base case：比如n=13,超过13的全部淘汰停止递归
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {   // 非第一位数的其他位数，从0到9开始
            dfs(res, 10 * cur + i, n);   // 每次当前位的cur*10作为下一位数的高位
        }
    }

    // 非递归解法
    public List<Integer> lexicalOrder1(int n) {
        PriorityQueue<String> queue = new PriorityQueue<>();// 默认就是字典序排序
        for (int i = 1; i <= n; i++) {
            queue.add(String.valueOf(i));
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(Integer.valueOf(queue.poll()));
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        List<Integer> res = solution.lexicalOrder(n);
        System.out.println(res);
    }
}
