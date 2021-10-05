package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.判断完全二叉树的结点个数;

import 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.判断是否是平衡二叉树.TreeNode;

public class LC222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = mostLeftLevel(root, 1);
        return bs(root, 1, h);
    }

    // treeHeight表示树的左子树总高度，方法返回的是表示以node为头的数的二叉树个数是多少
    public int bs(TreeNode node, int level, int h) {
        if (level == h) {
            return 1;
        }
        // 1.右子树的高==左子树的高度，则说明左子树为满二叉树，左子树结点数直接求出为2^(h-l)
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //2.右子树的高!=左子树的高度，则说明右子树为满二叉树，右子树结点数直接求出为2^(h-l-1)
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    // 判断当前节点的左子树的最大深度，level初始化为1，最后需要减1
    public int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
