package 牛客算法课.基础班.课6_二叉树递归套路.Q01_判断二叉搜索树;


import 牛客算法课.utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class IsBST {
    // 方法1：验证是否是二叉搜索树，利用中序遍历改写
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        double preVal = -Double.MAX_VALUE;// 记录前一个结点的值
        while (!stack.isEmpty() || root != null) {
            if (root != null) {// 中序遍历，先存左子树
                stack.push(root);
                root = root.left;
            } else {// 右子树取出，必须>左子树，否则不是BST
                root = stack.pop();
                if (root.val <= preVal) { // 右子树<=pre，必不是BST
                    return false;
                }
                preVal = root.val;// 否则，更新pre
                root = root.right;
            }
        }
        return true;
    }

    // 方法二：套用判断平衡二叉树的递归模版
    class ReturnInfo {
        // 需要三个信息
        public boolean isBST;
        public int min;
        public int max;

        public ReturnInfo(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {

        return process(root).isBST;
    }

    public ReturnInfo process(TreeNode node) {
        if (node == null) {
            // 因为min，max不好判断，所以这里直接返回null
            // 所以使用base case时,需要加非空判断
            return null;
        }
        ReturnInfo leftInfo = process(node.left);
        ReturnInfo rightInfo = process(node.right);
        // 后续遍历获取左右子树的三个信息进行判断
        int min = node.val;
        int max = node.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = true;
        if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= node.val)) {
            isBST = false;
        }
        if (rightInfo != null && (!rightInfo.isBST || rightInfo.min <= node.val)) {
            isBST = false;
        }
        return new ReturnInfo(isBST, min, max);
    }
}
