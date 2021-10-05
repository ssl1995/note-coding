package 读书笔记.剑指Offer.第二版.剑指Offer32_之字打印二叉树;

import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class JZ59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        // 牛客NC14，限定死只能用ArrayList这个数据结构作为队列
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        int index = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.get(index);
                queue.remove(index);
                // 层数假设从0开始，偶数层=从左到右打印
                if (res.size() % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);// 层数假设从1开始，奇数层=从右往左打印
                }
                // 以下是正常层次遍历存结点
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
