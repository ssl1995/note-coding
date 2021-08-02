package tag刷题.C05_树问题.剑指Offer26_树的子结构;


import tag刷题.utils.TreeNode;

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // base case:空节点，返回false
        if (A == null || B == null) {
            return false;
        }
        // 先判断A的先序序列中是否用B || 如A中先序有B，则isContainB判断左右子树能否一一对应
        return isSubStructure(A.left, B) || isSubStructure(A.right, B) || isContainB(A, B);
    }

    // 判断A中以root为根节点的树，是否能匹配上match
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
