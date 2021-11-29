package 剑指Offer.专项突击版.第7章_队列.q45_二叉树最底层最左边的值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/9 2:49 下午
 * @description
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        // 一开始bottomLeft就要更新根节点的值
        int bottomLeft = root.val;

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    // 队列的peek是队列最左边的值
                    bottomLeft = queue1.peek().val;
                }
            }

        }
        return bottomLeft;
    }
}
