package 刷题笔记.力扣.LC113_路径之和II;

import 学习笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/10 11:45 PM
 * @description
 */
public class Solution {

    private List<List<Integer>> res;
    private List<Integer> path;

    /**
     * 输出二叉树中所有路径和为sum的路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        process(root, targetSum);
        return res;
    }

    private void process(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        process(root.left, targetSum);
        process(root.right, targetSum);
        path.remove(path.size() - 1);
    }


}
