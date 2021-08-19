package 剑指Offer.正序版.剑指Offer07_重建二叉树;

import 剑指Offer.utils.TreeNode;

public class JZ4 {

    private int[] preArr;
    private int[] inArr;// 牛客不能用Map


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.preArr = pre;
        this.inArr = in;
        return recur(0, 0, in.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preArr[root]);
        int i = getIndexOfInArr(root);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

    private int getIndexOfInArr(int root) {
        for (int i = 0; i < inArr.length; i++) {
            if (preArr[root] == inArr[i]) {
                return i;
            }
        }
        return -1;
    }
}
