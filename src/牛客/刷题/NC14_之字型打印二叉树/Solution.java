package 牛客.刷题.NC14_之字型打印二叉树;

import 力扣.剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 牛客NC14，限定死只能用ArrayList这个数据结构作为队列
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 从size到0(取不到0)，有size次取queue数据
            for (int i = queue.size(); i > 0; i--) {
                // 在ArrayList中获取第一个元素，并移除
                TreeNode node = queue.get(0);
                queue.remove(0);
                // res.size从0开始=第一层，尾插法
                if (res.size() % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        root.left = n2;
        root.right = n3;
        n3.left = n4;
        n3.right = n5;
        Solution solution = new Solution();
        System.out.println(solution.Print(root));
        System.out.println("----");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        System.out.println(list);

    }
}
