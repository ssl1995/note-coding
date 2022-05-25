package 学习笔记.牛客算法课.基础班提升.课4_树形dp和morries遍历.Q03_Morris遍历;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

public class MorrisTraversal {

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /*
        原始Morris:假设cur指针从头结点开始遍历,根据节点的左右孩子null指针可以回到自己两次
            1.如果cur没有左孩子,cur向右移动
            2.如果cur有左孩子,找到左子树上最右的结点mostRight
                a.如果mostRight的右指针指向null,让其指向cur,然后cur向左移动
                b.如果mostRight的右指针指向cur,让其指向null,然后cur向右移动
            3.cur为null时遍历结束
     */
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 当前节点有左孩子,就利用mostRight判断左移还是右移
            if (mostRight != null) {
                // 最右节点存在且从来没有指向过cur，就一直右下去找最右节点
                while (mostRight.right != null && mostRight.right != cur) {// 找到最右节点
                    mostRight = mostRight.right;
                }
                // 第一次来到最右节点:没有指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;// 结束当前循环
                } else {
                    // 第二次来到最右节点:指向了cur
                    mostRight.right = null;
                }
            }
            // 当前节点没有左孩子,就向右移动
            cur = cur.left;
        }
    }


    /*
        先序Morris:自己手动写一个普通m遍历到结果、常规先序遍历的结果,一比对就发现规律
            规律:第二次来到的都不要,等价于
            1.只能到达一次的节点(叶子节点),直接打印
            2.能来到两次的节点,第一次打印
     */
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 能打印两次的结点:mostRight不为空
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {

                    // 能到达两次的,第一次到达打印
                    System.out.print(cur.value + " ");

                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {// 只能到达一次的结点:mostRight为null,直接打印

                System.out.print(cur.value + " ");

            }
            cur = cur.right;
        }
        System.out.println();
    }

    /*
     中序Morris:自己手动写一个普通m遍历到结果、常规中序遍历的结果,一比对就发现规律
            规律:第一次来到的都不要,等价于
            1.只能到达一次的节点(叶子节点),直接打印
            2.能来到两次的节点,第二次打印
     */
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            // 无论是到达两次还是只能到达一次,mostRight都是null
            // 只能到达一次，直接打印
            // 能到达两次，第二次打印
            System.out.print(cur.value + " ");

            cur = cur.right;
        }
        System.out.println();
    }

    /*
        Morris后序遍历:和前序、中序完全不一样了
            1.只能到达一次的,不用管
            2.能到达两次的,第二次到达时逆序打印左子树上的右边界
            3.遍历完整颗树后,逆序打印整颗树的右边界
     */
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    // 第二次来到该节点，逆序打印左子树的右边界
                    printNode(cur.left);
                }
            }
            cur = cur.right;
        }
        // 遍历完,再逆序打印整颗树的右边界
        printNode(head);
        System.out.println();
    }

    // Morris后序遍历:逆序打印一颗树
    public static void printNode(Node head) {
        Node tail = reverseNode(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseNode(tail);
    }

    // Morris后序遍历:反转一颗树,类似反转单链表
    public static Node reverseNode(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;// 将反转单链表的next改成right即可
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    // Q:利用Morris方法判断是否是搜索二叉树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        // 力扣边界:这里使用int会越界,所以使用Long的最小值
        long preValue = Long.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            // 如果第二次来到的结点值不产生升序,就不是二叉搜索树
            if (cur.val <= preValue) {
                return false;
            }
            // 否则,更新pre
            preValue = cur.val;

            cur = cur.right;
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        morris(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);

    }

}
