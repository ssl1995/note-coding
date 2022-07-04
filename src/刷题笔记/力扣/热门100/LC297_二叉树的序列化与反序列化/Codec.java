package 刷题笔记.力扣.热门100.LC297_二叉树的序列化与反序列化;

import 刷题笔记.力扣.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/20 9:45 AM
 * @Describe:
 */
public class Codec {

    /**
     * 序列化-二叉树
     * 先序遍历
     */
    public String serialize(TreeNode root) {
        // 遇见空节点，以#!结尾
        if (root == null) {
            return "#!";
        }
        // 遇见当期节点，以!结尾
        String res = root.val + "!";

        res += serialize(root.left);
        res += serialize(root.right);
        // "12!3!#!#!#!"
        return res;
    }

    /**
     * 反序列化-二叉树
     */
    public TreeNode deserialize(String data) {
        // "12!3!#!#!#!" -> [12,3,#,#,#]
        String[] strings = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String num : strings) {
            queue.offer(num);
        }
        return process(queue);
    }

    private TreeNode process(Queue<String> queue) {
        String num = queue.poll();
        if ("#".equals(num)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(num));
        root.left = process(queue);
        root.right = process(queue);
        return root;

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node1 = new TreeNode(12);
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;

        String serialize = codec.serialize(node1);
        System.out.println("序列化：" + serialize);

        TreeNode root = codec.deserialize(serialize);
        System.out.println("反序列化后根：" + root.val);

    }
}
