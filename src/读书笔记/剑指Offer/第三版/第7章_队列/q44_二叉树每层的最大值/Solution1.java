package 读书笔记.剑指Offer.第三版.第7章_队列.q44_二叉树每层的最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/9 9:13 上午
 * @description
 */
public class Solution1 {
    // 双队列
    public List<Integer> largestValues(TreeNode root) {
        int max = Integer.MIN_VALUE;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue1.offer(root);
        }

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                res.add(max);
                max = Integer.MIN_VALUE;

                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
