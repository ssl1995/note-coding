package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q04_二叉树宽度;

import 牛客算法课.utils.TreeNode;

import java.util.*;

public class TreeMaxWidth {

    private int maxWidth;
    private Map<Integer, Integer> map;// <深度，该层最左结点>


    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int index) {
        if (root == null) return;
        // putIfAbsent():如果key对应的value已经存在，就返回老的value，否则才更新key,value
        map.putIfAbsent(depth, index);
        maxWidth = Math.max(maxWidth, index - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * index + 1);// 先来最左边，所以map保存了最左边结点的坐标
        dfs(root.right, depth + 1, 2 * index + 2);
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
