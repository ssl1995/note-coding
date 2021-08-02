package tag刷题.C05_树问题.剑指Offer36_二叉搜索树和双向链表;

public class Solution {

    private Node pre;
    private Node head;

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

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        // 二叉搜索树中序遍历:保证从小到大
        if (pre == null) {// pre=null,说明是第一次来到最左结点，head记录未来双向链表的头结点
            head = root;
        } else {// pre!=null，更新pre的后继
            pre.right = root;
        }
        root.left = pre;// 更新cur的前驱
        pre = root;// pre后移

        dfs(root.right);

    }
}
