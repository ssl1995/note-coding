package 剑指Offer.专项突击版.第8章_树.q56_二叉搜索树中两个节点的值之和;

import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2021/10/14 8:28 上午
 * @description
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        // 自定义两个迭代器
        BSTIterator nextIter = new BSTIterator(root);
        BSTIteratorReversed preIter = new BSTIteratorReversed(root);
        // 模拟双指针
        int next = nextIter.next();
        int pre = preIter.next();

        while (next != pre) {
            if (next + pre == k) {
                return true;
            } else if (next + pre < k) {
                next = nextIter.next();
            } else {
                pre = preIter.next();
            }
        }
        return false;
    }
}

class BSTIterator {
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

class BSTIteratorReversed {
    private LinkedList<TreeNode> stack;
    private TreeNode cur;

    public BSTIteratorReversed(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }

    public int next() {
        // 中序遍历第一个while循环体内代码
        while (cur != null) {
            stack.push(cur);

            cur = cur.right;
        }
        cur = stack.pop();
        int val = cur.val;

        cur = cur.left;
        return val;
    }

    public boolean hasNext() {
        // 中序遍历第一个while循环体内代码-判断条件
        return cur != null || !stack.isEmpty();
    }
}
