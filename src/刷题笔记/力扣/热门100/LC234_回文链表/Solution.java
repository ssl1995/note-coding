package 刷题笔记.力扣.热门100.LC234_回文链表;

import 刷题笔记.力扣.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/6/19 10:30
 * @description
 */
public class Solution {
    /**
     * 回文链表
     * 示例：
     * 输入：head = [1,2,2,1]
     * 输出：true
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 最简单的方式：将链表数组转换为数组，然后利用数组的双指针进行判断
        List<Integer> temp = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            temp.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = temp.size() - 1;
        while (left <= right) {
            if (!temp.get(left).equals(temp.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
