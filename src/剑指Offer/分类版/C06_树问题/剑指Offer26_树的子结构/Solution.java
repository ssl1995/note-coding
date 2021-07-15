package 剑指Offer.分类版.C06_树问题.剑指Offer26_树的子结构;


import 剑指Offer.utils.TreeNode;

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isContainB(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断以root为根节点是否包含B
    private boolean isContainB(TreeNode node, TreeNode B) {
        // 一定是先判断B是否为空,返回true
        if (B == null) {
            return true;
        }
        // A为空或者A值不等于B值,返回false
        if (node == null || node.val != B.val) {
            return false;
        }
        // 子结构:必须是左左对应，右右对应。不能是左右分开对应
        return isContainB(node.left, B.left) && isContainB(node.right, B.right);
    }
}
