package 牛客算法课.初级班.课5_链表的环形问题和二叉树;

import 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

public class SuccessorNode {

    public Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        // 1.node有右孩子，后继是右边子树的最左边的结点
        if (node.right != null) {
            return getLeftMost(node);
        } else {
            // 2.node无右子树，先获得其父节点
            Node parent = node.parent;
            // 3.node不是父节点的左孩子，则后继不会是父节点，父节点向上移动
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            // 4.循环结束，父节点就是node的后继结点
            return parent;
        }
    }

    public Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
