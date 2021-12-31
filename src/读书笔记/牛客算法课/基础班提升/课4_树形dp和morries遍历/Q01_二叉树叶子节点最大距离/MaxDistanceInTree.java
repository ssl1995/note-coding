package 读书笔记.牛客算法课.基础班提升.课4_树形dp和morries遍历.Q01_二叉树叶子节点最大距离;

public class MaxDistanceInTree {
    // 二叉树结点类型
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // Q:获取二叉树叶子节点间的最大距离
    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    // 定义树形dp收集的数据结构：找到左右子树需要收集的信息，最大距离和高度
    public static class ReturnType {
        public int maxDistance;// 情况1:头结点不参与,需要收集距离
        public int height;// 情况2:头结点参与,需要收集高度

        public ReturnType(int m, int h) {
            this.maxDistance = m;
            this.height = h;
        }
    }

    // 递归函数
    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }
        // 后序遍历获取左右子树全部信息
        ReturnType leftInfo = process(head.left);
        ReturnType rightInfo = process(head.right);
        int includeHeadDistance = leftInfo.height + 1 + rightInfo.height;// 利用高度信息推出头结点参与的最大距离
        int p1 = leftInfo.maxDistance;// 利用距离，推出头结点不参与的最大距离
        int p2 = rightInfo.maxDistance;
        int distance = Math.max(Math.max(p1, p2), includeHeadDistance);// 以上两者取最大=整颗数最大距离
        int height = Math.max(leftInfo.height, leftInfo.height) + 1;// 利用高度+1=整颗树的高度
        return new ReturnType(distance, height);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistance(head1));
    }

}
