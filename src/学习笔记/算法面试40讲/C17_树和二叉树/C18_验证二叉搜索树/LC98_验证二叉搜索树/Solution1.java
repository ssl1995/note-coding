package 学习笔记.算法面试40讲.C17_树和二叉树.C18_验证二叉搜索树.LC98_验证二叉搜索树;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/17 8:06 AM
 * @description
 */
public class Solution1 {
    /**
     * long类型
     */
    public long pre = Long.MIN_VALUE;

    /**
     * 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 获取左子树是否BST
        boolean left = isValidBST(root.left);
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
        return isValidBST(root.right);
    }


}
