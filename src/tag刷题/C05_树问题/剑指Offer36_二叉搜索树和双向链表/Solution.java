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

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        // 二叉搜索树中序遍历:保证从小到大
        dfs(cur.left);
        // 更新pre
        if (pre == null) {// 当前cur就是head
            head = cur;
        } else {// pre存在,更新pre的右指针
            pre.right = cur;
        }
        // 更新cur
        cur.left = pre;
        pre = cur;
        dfs(cur.right);

    }
}
