package 刷题笔记.力扣.热门100.LC114_二叉树展开为链表;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/21 10:55 PM
 * @description
 */
public class Solution {
    /**
     * 二叉树展开为链表
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 注意：
     * （1）right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * （2）展开后的单链表与二叉树先序顺序相同
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<TreeNode> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            list.add(node);
            // 非递归前序：先右后左
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode pre = list.get(i);
            TreeNode next = list.get(i + 1);
            // 同步更新pre即可
            pre.left = null;
            pre.right = next;
        }

    }
}
