package tag刷题.C06_树问题.NC45_二叉树的前中后序遍历;

import tag刷题.utils.TreeNode;
import 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    private int[] inOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list2IntArray(list);
    }

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
            temp.push(root);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!temp.isEmpty()) {
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
