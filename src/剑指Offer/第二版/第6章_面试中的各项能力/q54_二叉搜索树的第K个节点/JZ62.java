package 剑指Offer.第二版.第6章_面试中的各项能力.q54_二叉搜索树的第K个节点;

import 剑指Offer.utils.TreeNode;


public class JZ62 {

    private int[] arr;
    private int index;
    private int len;

    TreeNode KthNode(TreeNode pRoot, int k) {
        getNodeCount(pRoot);
        if (k == 0 || k > len) {// 判断k越界
            return null;
        }
        arr = new int[len];
        index = 0;
        inOrder(pRoot);
        // 牛客返回的是第k小的数
        // 第1小的数，下标为0
        // 第k小的数，小标为k
        return new TreeNode(arr[k - 1]);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        arr[index++] = root.val;
        inOrder(root.right);
    }

    private void getNodeCount(TreeNode root) {
        if (root == null) {
            return;
        }
        len++;
        getNodeCount(root.left);
        getNodeCount(root.right);
    }

    public static void main(String[] args) {
        JZ62 jz62 = new JZ62();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        int k = 3;
        System.out.println(jz62.KthNode(n1, 3).val);
    }
}
