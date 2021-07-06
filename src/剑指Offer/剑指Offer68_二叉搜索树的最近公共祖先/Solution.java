package 剑指Offer.剑指Offer68_二叉搜索树的最近公共祖先;


import utils.TreeNode;

public class Solution {

    // 法1:递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            // 每次迭代记录当前结果,所以每次都要return
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    // 法2:迭代法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p,q都在root的右子树,最近公共祖先一定在右子树
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                // p,q都在root的左子树,最近公共祖先一定在左子树
                root = root.left;
            } else {
                // p,q在root的左右两边,最近公共祖先就是root
                break;
            }
        }
        return root;
    }

    // 法3:对法2进行优化,保证p.val<q.val,减少while判断条件
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 保证左小右大,
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            // root比最小的还小,说明root出现在了p,q的左边,那么公共祖先在root的右边
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                // root比最大的还大,说明root出现在了p,q的右边,那么公共祖先在root的左边
                root = root.left;
            } else {
                // root既不比p,q中最大的大,最小的小,最近公共祖先就是root,停止循环
                break;
            }
        }
        return root;
    }
}
