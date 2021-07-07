package 剑指Offer.剑指Offer54_二叉搜索树的第K个节点;


import 剑指Offer.utils.TreeNode;

public class Solution1 {
    // 法2:二叉搜索树的中序倒序遍历
    private int res;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.res = 0;
        this.k = k;
        inOrderByRL(root);
        return res;
    }


    private void inOrderByRL(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先遍历右子树
        inOrderByRL(root.right);
        // 如果已经找到第k大的数,下一次的遍历直接停止
        if (k == 0) {
            return;
        }
        // 还没有找到第k大的数,k-1,判断是否这一层是否是第k大的数
        k--;
        if (k == 0) {
            res = root.val;
        }
        // 再遍历左子树
        inOrderByRL(root.left);
    }
}
