package 剑指Offer.第二版.第2章_面试需要的基础知识.q07_重建二叉树;

import 剑指Offer.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int[] preorder;
    // 查找root在中序遍历中的下标
    private Map<Integer, Integer> inMap;

    /**
     * 根据前序和中序遍历结果，重建二叉树
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 重建二叉树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inMap = new HashMap<>();
        // map存中序遍历元素值和索引，提高查找效率
        // 但是牛客不能使用map，力扣可以用，牛客使用普通查找即可
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }


    /**
     * 根据前序和中序，递归生成二叉树
     *
     * @param root  在preorder中根节点的坐标
     * @param left  在inMap中左孩子左边界下标
     * @param right 在inMap中右孩子右边界下标
     * @return 根节点
     */
    private TreeNode recur(int root, int left, int right) {
        // base case：左子树索引越过右子树索引，代表没法形成结点，递归返回null
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);// 建立当前层的根节点:node
        int i = inMap.get(preorder[root]);// node在中序中的索引值
        // node的左子树递归:左子树根节点root+1,左子树范围[left,i-1]
        node.left = recur(root + 1, left, i - 1);
        // node的右子树递归:右子树根节点root+i-left+1,右子树范围[i+1,right]
        node.right = recur(root + i - left + 1, i + 1, right);
        // 递归回溯,当前node作为上一层的左or右节点
        return node;
    }
}
