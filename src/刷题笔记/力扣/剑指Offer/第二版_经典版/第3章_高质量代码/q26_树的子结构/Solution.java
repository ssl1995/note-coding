package 刷题笔记.力扣.剑指Offer.第二版_经典版.第3章_高质量代码.q26_树的子结构;


import 刷题笔记.力扣.utils.TreeNode;

public class Solution {

    /**
     * 判断B是否是A的子树
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // base case:空节点，返回false
        if (A == null || B == null) {
            return false;
        }
        // A的子树包含B 或 A的左子树包含B 或 A的右子树包含B
        return isContainB(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 以root为根节点的子树，是否包含树match
     */
    private boolean isContainB(TreeNode root, TreeNode match) {
        // base1：match到达叶子，说明匹配完成，返回true
        if (match == null) {
            return true;
        }
        // base2：root为null或者两者值不相同，未匹配成功，返回false
        if (root == null || root.val != match.val) {
            return false;
        }
        // 判断A的左子树是否和B的左子树相等 且 A的右子树和B的右子树相等
        return isContainB(root.left, match.left) && isContainB(root.right, match.right);
    }
}
