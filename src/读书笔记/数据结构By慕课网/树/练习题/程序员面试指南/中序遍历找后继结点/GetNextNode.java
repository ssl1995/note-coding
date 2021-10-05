package 读书笔记.数据结构By慕课网.树.练习题.程序员面试指南.中序遍历找后继结点;

public class GetNextNode {

    public Node getNextNode(Node node) {
        if (node == null) {
            return null;
        }
        // 1.有右孩子，则中序遍历的后继结点:当前结点右子树的最左结点
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            // 2.没有右孩子，中序遍历的后继结点:无左孩子的父节点的父节点
            Node parent = node.parent;
            // 核心:parent!=null保证了最右孩子遍历到根节点，根节点无父节点的情况，此时返回null
            while (parent != null && parent.left != null) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
