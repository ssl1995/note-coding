package 牛客.算法课.基础班.课6_二叉树递归套路.Q03_判断满二叉树;


import 牛客.算法课.utils.TreeNode;

public class isFullBT {
    // 二叉树套路：获得高度和结点总数
    class ReturnInfo {
        public int height;
        public int nodes;

        public ReturnInfo(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    // 判断是否是完全二叉树
    public boolean isFullBT(TreeNode root) {
        ReturnInfo info = process(root);
        // 满二叉树：总节点数=2^高度-1
        return info.nodes == ((int) Math.pow(2, info.height) - 1);
    }

    private ReturnInfo process(TreeNode node) {
        if (node == null) {
            return new ReturnInfo(0, 0);
        }
        ReturnInfo leftInfo = process(node.left);
        ReturnInfo rightInfo = process(node.right);
        // 后续遍历获取高度和结点总数
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new ReturnInfo(height, nodes);
    }
}
