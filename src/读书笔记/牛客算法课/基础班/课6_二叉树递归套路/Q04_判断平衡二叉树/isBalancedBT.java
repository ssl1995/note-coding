package 读书笔记.牛客算法课.基础班.课6_二叉树递归套路.Q04_判断平衡二叉树;


import 读书笔记.牛客算法课.utils.TreeNode;

public class isBalancedBT {
    // 判断是否是平衡二叉树，需要子树的两个信息：平衡和高度
    class BalanceAndHeightInfo {
        public boolean balanced;
        public int height;

        public BalanceAndHeightInfo(boolean b, int h) {
            this.balanced = b;
            this.height = h;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).balanced;
    }

    private BalanceAndHeightInfo process(TreeNode node) {
        if (node == null) {
            return new BalanceAndHeightInfo(true, 0);// 空结点是平衡的
        }
        BalanceAndHeightInfo leftInfo = process(node.left);
        BalanceAndHeightInfo rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.balanced && rightInfo.balanced && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new BalanceAndHeightInfo(isBalanced, height);
    }
}
