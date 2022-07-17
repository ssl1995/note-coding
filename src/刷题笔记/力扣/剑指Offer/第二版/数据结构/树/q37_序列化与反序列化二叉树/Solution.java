package 刷题笔记.力扣.剑指Offer.第二版.数据结构.树.q37_序列化与反序列化二叉树;


import 刷题笔记.力扣.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 序列化二叉树,可以按照力扣的格式：[1,2,null,4,5]
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // node值不为null
            if (node != null) {
                sb.append(node.val).append(",");
                // 队列中每次放入node的左右孩子即可，不用考虑左右孩子是否为null
                queue.add(node.left);
                queue.add(node.right);
            } else {
                // node值为null,结果字符串加null,记得删除最后一个逗号即可
                sb.append("null,");
            }
        }
        // 删除最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反序列化二叉树
     */
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        // 去掉头尾的"[]"，并根据逗号分离成字符串数组
        String[] split = data.substring(1, data.length() - 1).split(",");
        // 生产根节点
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        // 队列维持左右孩子
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 根节点已生成,遍历指针从split的下标1开始
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[index])) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.left);
            }
            index++;
            if (!"null".equals(split[index])) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        String res = solution.serialize(n1);
        System.out.println(res);

    }

}
