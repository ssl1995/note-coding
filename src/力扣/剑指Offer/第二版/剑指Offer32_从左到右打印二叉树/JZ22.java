package 力扣.剑指Offer.第二版.剑指Offer32_从左到右打印二叉树;

import 力扣.剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class JZ22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 牛客只能用ArrayList
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int index = 0;// 用指针=0来维护队列头部
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.get(index);
            queue.remove(index);
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }
}
