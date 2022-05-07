package 刷题笔记.牛客.NC8_到叶子节点和为指定值的路径;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.ArrayList;

public class Solution2 {
    // 求根节点到叶子节点路径和为指定值的

    // 使用回溯
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // recall1(root, sum, res, temp);
        recall2(root, sum, res, temp);
        return res;
    }

    // 回溯写法2:最好记的方法,面试时候用这个
    private void recall2(TreeNode root, int sum,
                         ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        sum -= root.val;
        // 如果来到叶子节点并且sum已经减0了，就加入到res中
        if (root.left == null && root.right == null && sum == 0) {
            // 复制temp成新ArrayList进res
            res.add(new ArrayList<>(temp));
        }
        recall2(root.left, sum, res, temp);
        recall2(root.right, sum, res, temp);
        // 倒数第二个递归调用这一行，回溯掉之前使用的结果
        temp.remove(temp.size() - 1);
    }


    // 回溯写法1
    private void recall1(TreeNode root, int sum,
                         ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        sum -= root.val;
        // 如果来到叶子节点并且sum已经减到0了，就加入到res中
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(temp));
            // 因为下一句就return，不会再走最后一行的remove
            // 所以这里要把这一轮递归加进去的移除掉
            temp.remove(temp.size() - 1);
            return;// 当前递归结束
        }
        recall1(root.left, sum, res, temp);
        recall1(root.right, sum, res, temp);
        // 倒数第二个递归调用这一行，回溯掉之前使用的结果
        temp.remove(temp.size() - 1);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int sum = 3;
        ArrayList<ArrayList<Integer>> res = solution.pathSum(root, sum);
        System.out.println(res);
    }
}
