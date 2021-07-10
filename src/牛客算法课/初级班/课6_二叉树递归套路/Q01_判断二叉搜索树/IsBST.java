package 牛客算法课.初级班.课6_二叉树递归套路.Q01_判断二叉搜索树;


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
        // 保证测试用例的结果正确，类型用Double
        double preVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 当前节点值肯定比它孩子节点小，否则就不是BST
                if (root.val <= preVal) {
                    return false;
                }
                // 如果满足BST，更新preVal
                preVal = root.val;
                root = root.right;
            }
        }
        return true;
    }

    // 方法2：递归法，使用list存中序遍历结果
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        // 递归完成中序遍历，list存中序遍历结果
        inOrder(root, list);
        Double preVal = -Double.MAX_VALUE;
        for (TreeNode node : list) {
            if (node.val <= preVal) {
                return false;
            }
            preVal = Double.valueOf(node.val);
        }
        return true;
    }

    private static void inOrder(TreeNode root, LinkedList<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.offer(root);
        inOrder(root.right, list);
    }

    // 方法三：套用判断平衡二叉树的递归模版
    class ReturnInfo {
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
        // min和max初始化都为node.val
        int min = node.val;
        int max = node.val;
        // 获得整颗数的最大值,最小值
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
