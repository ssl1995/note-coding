package 刷题笔记.力扣.热门100.LC105_从前序与中序遍历序列构造二叉树;

import 刷题笔记.力扣.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/12/1 11:12 上午
 * @description
 */
public class Solution {
    /**
     * 保存前序序列
     */
    private int[] preorder;
    /**
     * 查找root在中序遍历中的下标
     */
    private Map<Integer, Integer> inMap;

    /**
     * 根据前序和中序遍历结果，重建二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inMap = new HashMap<>();

        // map存中序遍历元素值和索引，提高查找效率
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }


    /**
     * 递归生成二叉树
     *
     * @param root  前序序列中的根节点坐标
     * @param left  中序序列中的左子树起点坐标
     * @param right 中序序列中的右子树起点坐标
     * @return 返回这个结点
     */
    private TreeNode recur(int root, int left, int right) {
        // base case：左子树索引越过右子树索引，代表没法形成结点，递归返回null
        if (left > right) {
            return null;
        }
        // 生成根节点
        TreeNode node = new TreeNode(preorder[root]);

        // 根节点在中序的坐标
        int i = inMap.get(preorder[root]);

        // node的左子树递归:左子树根节点root+1,左子树范围[left,i-1]
        node.left = recur(root + 1, left, i - 1);
        // node的右子树递归:右子树根节点root+i-left+1,右子树范围[i+1,right]
        node.right = recur(root + i - left + 1, i + 1, right);

        // 递归回溯,当前node作为上一层的左or右节点
        return node;
    }
}
