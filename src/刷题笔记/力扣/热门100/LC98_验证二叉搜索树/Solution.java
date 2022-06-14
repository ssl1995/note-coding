package 刷题笔记.力扣.热门100.LC98_验证二叉搜索树;

import 刷题笔记.力扣.utils.TreeNode;

import java.util.LinkedList;


public class Solution {

    /**
     * pre是会超过int类型的边界值,所以使用Long的边界值
     */
    private long pre = Long.MIN_VALUE;

    /**
     * 验证是否是BST
     * 中序递归法
     */
    public boolean isValidBST(TreeNode root) {
        // 空节点，是BST，返回true
        if (root == null) {
            return true;
        }
        // 左子树是否BST
        boolean left = isValidBST(root.left);

        // 左子树不是BST
        if (!left) {
            return false;
        }

        // 当前节点的值>左子树pre,更新pre
        // 否则就不是BST
        if (root.val > pre) {
            pre = root.val;
        } else {
            return false;
        }

        // 右子树是否是BST
        return isValidBST(root.right);
    }


    /**
     * 验证是否是BST
     * 中序非递归
     */
    public boolean isValidBST1(TreeNode root) {
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


}
