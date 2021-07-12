package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q04_二叉树的宽度;

import 牛客算法课.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeMaxWidth {

    private int maxWidth;// 记录最大宽度
    private Map<Integer, Integer> map;// 记录每一层的第一个结点(深度,0)

    // 深度优先遍历
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<>();
        // 根节点起始下标i,左孩子2*i+1,右孩子2*i+2
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        // putIfAbsent():如果key是新key,就记录新key和新value
        // 如果是老key,替换老key,但value还是沿用之前的老value
        map.putIfAbsent(depth, pos);
        // 最大宽度长度:当前节点下标-这一层第一个结点的下标+1
        maxWidth = Math.max(maxWidth, pos - map.get(depth) + 1);
        // 先遍历左子树,每一层的第一个结点都保存起始下标(深度,0)
        dfs(root.left, depth + 1, 2 * pos + 1);
        // 从叶子节点第一个开始算宽度
        dfs(root.right, depth + 1, 2 * pos + 2);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;

        TreeMaxWidth treeMaxWidth = new TreeMaxWidth();
        int count = treeMaxWidth.widthOfBinaryTree(root);
        System.out.println(count);
    }
}
