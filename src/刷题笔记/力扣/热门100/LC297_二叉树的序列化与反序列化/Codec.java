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
        if (root == null) {
            return "#!";
        }
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
        String[] strings = data.split("!");
        Queue<String> queue = new LinkedList<>();
        // [12,3,#,#,#]
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
}
