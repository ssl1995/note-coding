package 学习笔记.剑指Offer.专项突击版.第8章_树.q54_所有大于或等于节点的值之和;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/13 8:40 上午
 * @description
 */
public class Solution {

    public TreeNode convertBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                // 改变常规中序遍历顺序：先遍历右子树，把≥的值放进栈
                cur = cur.right;
            }
            cur = stack.pop();

            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
