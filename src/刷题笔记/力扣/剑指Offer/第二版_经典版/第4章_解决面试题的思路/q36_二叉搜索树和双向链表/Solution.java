package 刷题笔记.力扣.剑指Offer.第二版_经典版.第4章_解决面试题的思路.q36_二叉搜索树和双向链表;

public class Solution {

    /**
     * pre记录dfs中root的前驱=root.left的位置
     */
    private Node pre;
    /**
     * head记录返回双向链表的头结点
     */
    private Node head;

    /**
     * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 中序遍历形成双向链表
        dfs(root);
        // 更新首尾指针,形成循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历二叉树，将二叉树分为：左孩子，根节点，右孩子
     */
    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        // 二叉搜索树中序遍历:保证从小到大
        // 更新pre的后继是否指向node
        if (pre == null) {
            head = node;
        } else {// pre!=null，说明当前node有pre，更新pre的后继
            pre.right = node;
        }
        // 更新node的前驱是否指向pre
        node.left = pre;

        // pre完成迭代
        pre = node;

        dfs(node.right);

    }
}
