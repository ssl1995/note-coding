package 剑指Offer.专项突击版.第8章_树.q56_二叉搜索树中两个节点的值之和;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/14 8:28 上午
 * @description
 */
public class Solution1 {
    public boolean findTarget(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        TreeNode cur = root;
        // 使用set存节点值，任意遍历都行，这里选用中序遍历BST
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (set.contains(k - cur.val)) {
                return true;
            }
            // 出栈以后再存节点值
            set.add(cur.val);
            cur = cur.right;

        }
        return false;
    }
}
