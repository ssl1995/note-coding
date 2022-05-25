package 学习笔记.极客时间.算法面试40讲.C17_树和二叉树.C18_验证二叉搜索树.LC98_验证二叉搜索树;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/17 8:06 AM
 * @description
 */
public class Solution {
    /**
     * 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        // 判断list元素是否是严格递增的
        for (int i = 1; i < list.size(); i++) {
            int pre = list.get(i - 1);
            int next = list.get(i);
            // 严格递增，有等于也不是严格递增
            if (pre >= next) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}
