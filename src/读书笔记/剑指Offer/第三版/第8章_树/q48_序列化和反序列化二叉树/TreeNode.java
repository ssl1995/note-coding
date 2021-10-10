package 读书笔记.剑指Offer.第三版.第8章_树.q48_序列化和反序列化二叉树;

/**
 * @author SongShengLin
 * @date 2021/10/8 9:20 上午
 * @description
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
