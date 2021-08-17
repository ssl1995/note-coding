package 牛客算法课.基础班.课5_链表的环形问题和二叉树.Q05_二叉树深度;


import 牛客算法课.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    // 递归法DFS
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            // 1.先记录出队元素的个数=当前层的队列的长度
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            depth++;
        }
        return depth;
    }

}
