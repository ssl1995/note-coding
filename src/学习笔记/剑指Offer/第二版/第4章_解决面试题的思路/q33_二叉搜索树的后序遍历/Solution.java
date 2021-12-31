package 学习笔记.剑指Offer.第二版.第4章_解决面试题的思路.q33_二叉搜索树的后序遍历;

public class Solution {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * 二叉搜索树后序遍历：左子树、右子树、根节点；并且左子树 < 根节点；右子树 >根节点
     */
    private boolean recur(int[] post, int left, int right) {
        // base case:左指针越过右指针，说明子树数量<=1，单个数一定是单个二叉树节点的后序遍历结果，返回true
        if (left >= right) {
            return true;
        }
        // i寻找右子树的第一个结点，将数组分为[0...i-1|i...right-1|right]，其中根节点=post[right]
        int i = left;
        while (post[i] < post[right]) {
            i++;
        }
        // j遍历[右子树部分]，其中每个值都应该>根节点，如果没有遍历到right不是BST
        int j = i;
        while (post[j] > post[right]) {
            j++;
        }
        // 后续匹配成功如下:
        // 1.遍历指针j是否到达根节点right，判断是否是二叉搜索树
        // 2.左孩子区间满足分治
        // 3.右孩子区间满足分治
        return j == right && recur(post, left, i - 1) && recur(post, i, right - 1);
    }

}
