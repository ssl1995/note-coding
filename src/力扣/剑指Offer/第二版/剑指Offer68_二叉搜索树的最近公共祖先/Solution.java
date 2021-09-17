package 力扣.剑指Offer.第二版.剑指Offer68_二叉搜索树的最近公共祖先;


import 力扣.剑指Offer.utils.TreeNode;

public class Solution {


    // 二叉搜索树最近公共祖先：BST特性左小右大+无重复结点，自己画图明确三种情况
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证p,q左小右大
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
                // root.val=p.val||root.val=q.val,root此时指向的就是最近公共祖先
                break;
            }
        }
        return root;
    }


}
