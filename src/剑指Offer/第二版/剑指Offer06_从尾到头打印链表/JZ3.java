package 剑指Offer.第二版.剑指Offer06_从尾到头打印链表;

import 剑指Offer.utils.ListNode;

import java.util.ArrayList;

public class JZ3 {

    // 牛客此题返回值是List，比力扣的返回值是int[]要方便很多
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        process(listNode, res);
        return res;
    }


    private void process(ListNode node, ArrayList<Integer> res) {
        if (node == null) {
            return;
        }
        process(node.next, res);
        res.add(node.val);
    }
}
