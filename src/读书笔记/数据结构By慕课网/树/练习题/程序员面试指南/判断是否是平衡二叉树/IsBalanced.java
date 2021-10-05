package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.判断是否是平衡二叉树;


public class IsBalanced {

    public boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    public ReturnType process(TreeNode head) {
        // 1.递归结束条件
        if (head == null) {
            // 空结点默认是平衡的，高度0并不会返回，所以没用
            return new ReturnType(true, 0);
        }
        // 2.递归获取左右子树情况
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        // 3.当前头结点的高度为左右子树最大值+1
        int height = Math.max(leftData.height, rightData.height) + 1;
        // 4.平衡的三个条件：左右子树平衡+高度差<2
        boolean isBalanced = leftData.isBalanced &&
                rightData.isBalanced &&
                Math.abs(leftData.height - rightData.height) < 2;
        // 5.返回
        return new ReturnType(isBalanced, height);
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int h) {
            this.isBalanced = isB;
            this.height = h;
        }
    }
}
