package 剑指Offer.分类版.C05_树问题.剑指Offer32_二叉树层次遍历;

import 剑指Offer.utils.TreeNode;

import java.util.ArrayList;


public class JZ60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        int index = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 层次遍历，需要从确定每层的长度
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.get(index);
                queue.remove(index);
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
