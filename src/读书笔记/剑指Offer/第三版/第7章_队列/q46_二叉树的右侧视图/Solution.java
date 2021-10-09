package 读书笔记.剑指Offer.第三版.第7章_队列.q46_二叉树的右侧视图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/9 3:06 下午
 * @description
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            // 当此时queue1是空的时候，node结点就是最后一个结点
            if (queue1.isEmpty()) {
                res.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
