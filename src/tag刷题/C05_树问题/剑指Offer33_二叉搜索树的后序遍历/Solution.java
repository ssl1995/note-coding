package tag刷题.C05_树问题.剑指Offer33_二叉搜索树的后序遍历;

public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        // 根节点永远为postorder[right]
        // 从左往后找出第一个>根节点的下标 = 右子树的第一个结点
        int i = left;
        while (postorder[i] < postorder[right]) {
            i++;
        }
        // 记录右子树结点
        int j = i;
        // 判断右子树[j,right-1]中是否存在<根节点的值
        while (postorder[i] > postorder[right]) {
            i++;
        }
        // 后续匹配成功如下:
        // 1.遍历指针i是否到达根节点right
        // 2.左孩子区间满足
        // 3.右孩子区间满足
        return i == right
                && recur(postorder, left, j - 1)
                && recur(postorder, j, right - 1);
    }

}
