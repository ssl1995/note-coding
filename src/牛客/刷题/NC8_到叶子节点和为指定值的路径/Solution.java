package 牛客.刷题.NC8_到叶子节点和为指定值的路径;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class Solution {
    // 求根节点到叶子节点路径和为指定值的

    // 使用dfs递归:学习什么是分支感染？
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, temp);
        return res;
    }

    private void dfs(TreeNode root, int sum,
                     ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }
        // 防止分支感染，每次新建一个list继承上次的temp
        ArrayList<Integer> subList = new ArrayList<>(temp);
        subList.add(root.val);
        // 如果来到叶子节点并且sum已经减到叶子节点的值了，就加入到res中
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(subList);
            return;// 当前递归结束
        }
        dfs(root.left, sum - root.val, res, subList);
        dfs(root.right, sum - root.val, res, subList);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int sum = 3;
        ArrayList<ArrayList<Integer>> res = solution.pathSum(root, sum);
        System.out.println(res);
    }
}
