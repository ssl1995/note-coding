package 力扣.热题100.LC662_二叉树的最大宽度;

import 牛客.算法课.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int maxWidth;// 记录最大宽度
    private Map<Integer, Integer> map;// 记录每一层的第一个结点(深度,0)

    // 深度优先遍历
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap<>();
        // 根节点起始下标i,左孩子2*i+1,右孩子2*i+2
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        // putIfAbsent():如果key是新key,就记录新key和新value
        // 如果是老key,替换老key,但value还是沿用之前的老value
        map.putIfAbsent(depth, pos);
        // 最大宽度长度:当前节点下标-这一层第一个结点的下标+1
        maxWidth = Math.max(maxWidth, pos - map.get(depth) + 1);
        // 先遍历左子树,每一层的第一个结点都保存起始下标(深度,0)
        dfs(root.left, depth + 1, 2 * pos + 1);
        // 从叶子节点第一个开始算宽度
        dfs(root.right, depth + 1, 2 * pos + 2);
    }

}
