package 慕课网数据结构.树.练习题.程序员面试指南.判断是否是完全二叉树;

import java.util.LinkedList;

public class IsCBT {


    public boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        // 0.层次遍历，每次都判断当点节点的完全性
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode l;
        TreeNode r;
        boolean needIsLeaf = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            // 1.需要叶子节点&&后序节点必须都是叶子节点 || 左空右不空，都是false
            if (needIsLeaf && (l != null || r != null)
                    || (l == null && r != null)) {
                return false;
            }
            // 2.有左子树\右子树都加入队列中
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                // 3.经过前三次if,此时肯定是双空or左不空右空的情况，标记为需要叶子节点的状态
                needIsLeaf = true;
            }
        }
        return true;
    }
}
