package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第8章_树.q53_二叉搜索树的下一个结点;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/12 8:49 上午
 * @description
 */
public class Solution {
    // 找二叉搜索树中的中序后继结点
    // 法1：BST非递归中序遍历，用一个布尔值记录是否遍历到p
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        boolean found = false;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (found) {
                break;
            } else if (p == cur) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }
}
