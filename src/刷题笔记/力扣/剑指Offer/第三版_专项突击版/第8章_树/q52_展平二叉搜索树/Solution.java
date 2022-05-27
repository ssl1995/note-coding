package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第8章_树.q52_展平二叉搜索树;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/12 8:33 上午
 * @description
 */
public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            // 让cur先遍历到最左结点,栈中只存左孩子节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur每次指向栈顶=每次指向BST中的左孩子
            cur = stack.pop();
            // prev指向当前节点展平后的父节点=上一轮的左孩子节点
            if (prev != null) {
                prev.right = cur;
            } else {
                // first指向原先BST的最左结点=展平后的根节点
                first = cur;
            }
            // 迭代，prev指向下一轮的展平后的父节点
            prev = cur;
            // cur左指针置空，然后右移
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
