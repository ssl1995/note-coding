package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第8章_树.q55_二叉搜索树迭代器;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/13 8:50 上午
 * @description
 */
public class BSTIterator {
    private LinkedList<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }

    public int next() {
        // 中序遍历第一个while循环体内代码
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        // 中序遍历第一个while循环体内代码-判断条件
        return cur != null || !stack.isEmpty();
    }
}
