package 读书笔记.剑指Offer.第二版.第3章_高质量代码.q26_树的子结构;


import 读书笔记.剑指Offer.utils.TreeNode;

public class Solution {

    /**
     * 判断B是否是A的子树
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // base case:空节点，返回false
        if (A == null || B == null) {
            return false;
        }
        // B是A的子结构||以A为根结点包含B
        return isSubStructure(A.left, B) || isSubStructure(A.right, B) || isContainB(A, B);
    }

    /**
     * 判断A中以root为根节点的树，是否能匹配上match
     */
    private boolean isContainB(TreeNode root, TreeNode match) {
        // base1：match越过叶子，说明匹配完成，返回true
        if (match == null) {
            return true;
        }
        // base2：root为null或者两者值不相同，未匹配成功，返回false
        if (root == null || root.val != match.val) {
            return false;
        }
        // 子结构:必须是左左对应，右右对应。不能是左右分开对应
        return isContainB(root.left, match.left) && isContainB(root.right, match.right);
    }
}
