package 刷题笔记.力扣.LC426_将二叉搜索树转化为排序的双向链表;

/**
 * @author SongShengLin
 * @date 2022/1/11 9:27 AM
 * @description
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
