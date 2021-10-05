package 读书笔记.剑指Offer.第二版.剑指Offer33_二叉搜索树的后序遍历;

public class JZ23 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        // 题目规定：空树不是二叉搜索树
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return recur(sequence, 0, sequence.length - 1);
    }

    private boolean recur(int[] post, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = left;
        while (post[i] < post[right]) {
            i++;
        }
        int j = i;
        while (post[j] > post[right]) {
            j++;
        }
        return j == right && recur(post, left, i - 1) && recur(post, i, right - 1);
    }

}
