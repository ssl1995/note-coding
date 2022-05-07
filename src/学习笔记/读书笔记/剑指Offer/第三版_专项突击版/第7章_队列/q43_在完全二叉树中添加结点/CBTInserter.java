package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第7章_队列.q43_在完全二叉树中添加结点;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/8 9:19 上午
 * @description
 */
public class CBTInserter {

    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        // 初始root是一个完全二叉树的根节点，找到左右孩子至少一个不为null的父节点
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            // 队列暂存当前节点的左右孩子
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;

            // 父节点的右孩子满了就要移除该节点，队列暂存其左右孩子
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
