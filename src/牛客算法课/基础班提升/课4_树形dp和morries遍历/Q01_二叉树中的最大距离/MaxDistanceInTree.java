package 牛客算法课.基础班提升.课4_树形dp和morries遍历.Q01_二叉树中的最大距离;

public class MaxDistanceInTree {
    // 结点类型
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // Q:获取二叉树节点间的最大距离
    public static int maxDistance(Node head) {

        return process(head).maxDistance;
    }

    // 找到左右子树需要收集的信息:最大距离和高度
    public static class ReturnType {
        public int maxDistance;// 情况1:头结点不参与,需要收集左右子树的最大距离
        public int height;// 情况2:头结点参与,需要收集左右子树的高度

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
        // 整颗树的最大距离:头结点参与下的最大距离和左右子树各自的最大距离,取最大值
        int includeHeadDistance = leftInfo.height + 1 + rightInfo.height;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int distance = Math.max(Math.max(p1, p2), includeHeadDistance);
        // 整颗数的最大高度:左右子树的高度最大值+1
        int height = Math.max(leftInfo.height, leftInfo.height) + 1;
        return new ReturnType(distance, height);
    }

    public static int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxfromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxfromLeft + maxFromRight + 1;
        record[0] = Math.max(maxfromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
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

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistance(head2));

    }

}
