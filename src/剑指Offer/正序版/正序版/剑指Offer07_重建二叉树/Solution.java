package 剑指Offer.正序版.正序版.剑指Offer07_重建二叉树;



import 剑指Offer.utils.TreeNode;

import java.util.HashMap;

public class Solution {

    private int[] preOrder;
    // 快速获取中序数组中元素的下标
    private HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        // map存中序遍历的索引,便于preOrder[root]返回inorder中查找
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        // 开始递归
        return recur(0, 0, inorder.length - 1);
    }


    private TreeNode recur(int root, int left, int right) {
        // 递归结束:没有结点值就结束
        if (left > right) {
            return null;
        }
        // 建立当前层的根节点:node
        TreeNode node = new TreeNode(preOrder[root]);
        // node在中序中的索引值
        int i = inOrderMap.get(preOrder[root]);
        // node的左子树递归:左子树根节点root+1,左子树范围[left,i-1]
        node.left = recur(root + 1, left, i - 1);
        // node的右子树递归:右子树根节点root+i-left+1,右子树范围[i+1,right]
        node.right = recur(root + i - left + 1, i + 1, right);
        // 递归回溯,当前node作为上一层的左or右节点
        return node;
    }
}
