package 剑指Offer.分类版.C06_二叉树.剑指Offer27_二叉树的镜像;



import 剑指Offer.utils.TreeNode;

import java.util.LinkedList;

public class Solution {

    // 法1:递归法1,暂存左孩子节点
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 暂存left结点
        TreeNode left = root.left;
        // 左节点指向右节点
        root.left = mirrorTree1(root.right);
        // 右节点指向暂存的left结点
        root.right = mirrorTree1(left);
        // 返回当前父节点
        return root;
    }

    // 法2:递归法2,前序遍历时进行交换
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree2(root.left);
        mirrorTree2(root.right);
        return root;
    }

    // 法3:用栈迭代
    public TreeNode mirrorTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 栈顶元素出队
            TreeNode top = stack.pop();
            // 使用栈就要先入栈,再交换
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            // 出队结点的左右孩子节点交换
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
        }
        return root;
    }

    // 法4:用队列迭代
    public TreeNode mirrorTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            // 当前队列出队
            TreeNode poll = queue.poll();
            // 使用队列就要先交换,再入队
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return root;
    }
}

