package 剑指Offer.C05_树问题.剑指Offer34_二叉树中和为某一值的路径;

import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class JZ24 {
    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> temp;

    // 路径定义:树的根结点到叶结点所经过的结点
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        temp = new ArrayList<>();
        backtrack(root, target);
        return res;
    }

    private void backtrack(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        target -= root.val;// target每次递减
        // 路径定义:树的根结点到叶结点所经过的结点
        if (target == 0 && root.left == null && root.right == null) {
            // 难点：再new一个ArrayList(temp)
            res.add(new ArrayList<>(temp));
        }
        if (root.left != null) {
            backtrack(root.left, target);
        }
        if (root.right != null) {
            backtrack(root.right, target);
        }
        // 回溯，移除temp末尾元素值
        temp.remove(temp.size() - 1);
    }
}
