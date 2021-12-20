package 剑指Offer.第二版.第4章_解决面试题的思路.q34_二叉树中和为某一值的路径;


import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;
    /**
     * 保存节点经过的路径
     */
    private List<Integer> path;

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        recur(root, target);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        // 要算路径和，先访问那个节点就加入该节点值，所以想到先序遍历
        // 并且路径和，需要知道之前访问哪些节点，所以保存路径进path
        path.add(root.val);
        target -= root.val;
        // 从根节点到叶子节点：root.left == null && root.right == null
        // 目标和：target减为0
        if (target == 0 && root.left == null && root.right == null) {
            // new ArrayList<>(path)形成新链表放入结果集
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            recur(root.left, target);
        }
        if (root.right != null) {
            recur(root.right, target);
        }
        // 回溯需要移除path末尾元素
        path.remove(path.size() - 1);
    }
}
