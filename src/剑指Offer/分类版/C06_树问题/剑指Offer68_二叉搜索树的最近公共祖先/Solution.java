package 剑指Offer.分类版.C06_树问题.剑指Offer68_二叉搜索树的最近公共祖先;


import 剑指Offer.utils.TreeNode;

public class Solution {

    // 法4:后序遍历,个人认为是最容易理解的方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 条件:p、q 为不同节点且均存在于给定的二叉搜索树中
        // 所以考虑把遍历过程中记录每个结点的祖先,叶子节点的祖先为null
        // 1.base case:null或者p,q;说明遇到这三个情况就直接返回它本身
        if (root == null || root == p || root == q) {
            return root;
        }
        // 2.后续遍历获取全部子树信息
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 3.左右子树不为空，说明左右子树必包含p、q,祖先就是root
        if (left != null && right != null) {
            return root;
        }
        // 4.左右子树不全空，说明祖先在不为空的子树上
        return left != null ? left : right;
    }

    // 法1:递归法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            // 每次迭代记录当前结果,所以每次都要return
            return lowestCommonAncestor1(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        return root;
    }

    // 法2:迭代法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
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
