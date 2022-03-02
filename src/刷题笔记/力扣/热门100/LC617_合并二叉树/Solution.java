package 刷题笔记.力扣.热门100.LC617_合并二叉树;

/**
 * @author SongShengLin
 * @date 2022/2/27 1:12 PM
 * @description
 */
public class Solution {
    /**
     * 合并二叉树
     * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值
     * 否则，不为 null 的节点将直接作为新二叉树的节点。
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        // 更新值
        n1.val += n2.val;
        // 更新左孩子
        n1.left = dfs(n1.left, n2.left);
        // 更新右孩子
        n1.right = dfs(n1.right, n2.right);
        return n1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);

        root1.left = node2;
        root1.right = node3;
        node2.left = node4;

        TreeNode root2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        root2.left = node5;
        root2.right = node6;
        node5.right = node7;
        node6.right = node8;

        TreeNode res = solution.mergeTrees(root1, root2);
        System.out.println(res.val);

    }
}
