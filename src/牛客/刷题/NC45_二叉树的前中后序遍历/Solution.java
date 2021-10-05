package 牛客.刷题.NC45_二叉树的前中后序遍历;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    // 实现二叉树的前中后序遍历
    public int[][] threeOrders(TreeNode root) {
        int[] pre = preOrder(root);
        int[] in = inOrder(root);
        int[] after = afterOrder(root);
        int[][] res = new int[3][];
        res[0] = pre;
        res[1] = in;
        res[2] = after;
        return res;
    }

    // 二叉树前序遍历
    private int[] preOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }

        }
        return list2IntArray(list);
    }

    // 二叉树中序遍历
    private int[] inOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {// 遍历指针不为null，就让一直push+左移
                stack.push(root);
                root = root.left;
            } else {
                // 遍历指针来到最左结点的孩子节点为null，出栈，往右孩子节点移动，记录在中序遍历结果值
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list2IntArray(list);
    }

    // 二叉树的后序遍历
    private int[] afterOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            temp.push(root);// 辅助栈入出栈元素
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!temp.isEmpty()) {// 清空辅助栈，得到结果集
            list.add(temp.pop().val);
        }
        return list2IntArray(list);

    }

    private int[] list2IntArray(ArrayList<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
