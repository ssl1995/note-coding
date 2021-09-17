package 力扣.刷题.LC98_验证二叉搜索树;

import 力扣.剑指Offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class Solution {

    // 本题pre是会超过int类型的边界值,所以使用Long的边界值
    private long pre = Long.MIN_VALUE;

    // 递归法1
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 获取左子树的信息
        boolean left = isValidBST1(root.left);
        if (!left) {
            return false;
        }
        // 当前节点的值>pre,更新pre;否则就不是BST
        if (root.val > pre) {
            pre = root.val;
        } else {
            return false;
        }
        // 继续检查右子树是否是BST
        return isValidBST1(root.right);
    }


    // 递归法2:傻白甜递归法
    public boolean isValidBST2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        process(root, list);
        long pre = Long.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur <= pre) {
                return false;
            } else {
                pre = cur;
            }
        }
        return true;
    }

    private void process(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        process(head.left, list);
        list.add(head.val);
        process(head.right, list);
    }

    // 非递归法:修改非递归中序遍历
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            // 中序非递归遍历先把所有左子树入栈
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 左子树到null就出栈，操作+入右子树
                root = stack.pop();
                if (root.val <= pre) {
                    return false;
                } else {
                    pre = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }

    // 二叉树套路法:
    class ReturnInfo {
        boolean isBST;
        int min;
        int max;

        ReturnInfo(boolean isBST, int min, int max) {
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
