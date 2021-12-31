package 读书笔记.剑指Offer.专项突击版.第7章_队列.q44_二叉树每层的最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/10/9 9:13 上午
 * @description
 */
public class Solution {
    // 单队列+双变量
    public List<Integer> largestValues(TreeNode root) {
        int current = 0;
        int next = 0;
        int max = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
            current = 1;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            // 当前层为0，更新下一层，记录这一层最大值结果
            if (current == 0) {
                current = next;
                next = 0;
                res.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}
