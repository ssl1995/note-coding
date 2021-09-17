package 力扣.刷题.LC94_二叉树的中序遍历;

import 力扣.剑指Offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 栈中先压入所有的左子树
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {// 左子树遍历压入完成
                // 依次出栈,每次出栈元素=最终结果,加入结果集中
                root = stack.pop();
                res.add(root.val);
                // 遍历指针指向其右子树,重复压入其左子树的过程
                root = root.right;
            }
        }
        return res;
    }
}
