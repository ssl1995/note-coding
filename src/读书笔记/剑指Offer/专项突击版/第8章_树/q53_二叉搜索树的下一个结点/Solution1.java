package 读书笔记.剑指Offer.专项突击版.第8章_树.q53_二叉搜索树的下一个结点;

/**
 * @author SongShengLin
 * @date 2021/10/12 8:49 上午
 * @description
 */
public class Solution1 {
    // 找二叉搜索树中的中序后继结点
    // 法2：BST的p结点的下一个结点：>p，且是它右孩子中最小的那个
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                // 在左孩子中找最小=BST中p结点中序遍历的下一个结点
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
