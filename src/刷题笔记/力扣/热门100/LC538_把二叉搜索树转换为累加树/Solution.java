package 刷题笔记.力扣.热门100.LC538_把二叉搜索树转换为累加树;

import 学习笔记.剑指Offer.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/26 11:29 PM
 * @description
 */
public class Solution {

    private int sum;

    /**
     * 把二叉搜索树转换为累加树
     * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 反中序遍历，得到递减数组
        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);
        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;

        node7.right = node9;

        solution.convertBST(node1);

        System.out.println(node1.val);

    }
}
