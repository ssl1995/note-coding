package 牛客.刷题.NC8_到叶子节点和为指定值的路径;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution1 {
    // 求根节点到叶子节点路径和为指定值的

    // 递归dfs改成非递归dfs
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 先序遍历需要的结点栈
        LinkedList<TreeNode> stackNode = new LinkedList<>();
        stackNode.push(root);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<ArrayList<Integer>> stackList = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        stackList.push(list);

        while (!stackNode.isEmpty()) {
            root = stackNode.pop();
            ArrayList<Integer> tempList = stackList.pop();
            if (root.left == null && root.right == null && sum == root.val) {
                res.add(tempList);
            }

            if (root.right != null) {
                tempList.add(root.right.val);
                stackList.push(new ArrayList<>(tempList));
                root.right.val += root.val;
                // 这样写不对:sum -= root.val;
                stackNode.push(root.right);
                tempList.remove(tempList.size() - 1);
            }

            if (root.left != null) {
                tempList.add(root.left.val);
                stackList.push(new ArrayList<>(tempList));
                root.left.val += root.val;
                // 这样写不对:sum -= root.val;
                stackNode.push(root.left);
                tempList.remove(tempList.size() - 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int sum = 3;
        ArrayList<ArrayList<Integer>> res = solution.pathSum(root, sum);
        System.out.println(res);
    }
}
