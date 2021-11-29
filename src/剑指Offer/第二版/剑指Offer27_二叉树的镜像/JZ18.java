package 剑指Offer.第二版.剑指Offer27_二叉树的镜像;

import 剑指Offer.utils.TreeNode;

public class JZ18 {

    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
