package 程序员代码面试指南.第3章_二叉树问题.序列化与反序列化二叉树;


import 剑指Offer.utils.TreeNode;

import java.util.LinkedList;

public class Solution {

    /*
        通过层序遍历，来实现二叉树的序列化
            遇到结点不为空,后面+!
            遇到空结点,后面+*！
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root).append("!");

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                sb.append(node.val).append("!");
                queue.add(node.left);
            } else if (node.left == null) {
                sb.append("#!");
            }

            if (node.right != null) {
                sb.append(node.val).append("!");
                queue.add(node.right);
            } else if (node.right == null) {
                sb.append("#!");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        // 普通结点:12! 空节点:#!
        // 比如：12!3!#!#!#!反序列化以!为分隔符,分成字符数组{12,3,#,#,#}
        String[] split = data.split("!");
        int index = 0;
        TreeNode head = generateNode(split[index++]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            // 层序遍历,遇到null就不用生产结点
            node = queue.poll();
            node.left = generateNode(split[index++]);
            node.right = generateNode(split[index++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    private TreeNode generateNode(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode deserialize = solution.deserialize("12!3!#!#!#!");
        System.out.println();
    }
}
