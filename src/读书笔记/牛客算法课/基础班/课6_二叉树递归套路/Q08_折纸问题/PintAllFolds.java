package 读书笔记.牛客算法课.基础班.课6_二叉树递归套路.Q08_折纸问题;

public class PintAllFolds {
    // 折纸问题:打印折纸过程
    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    // 从level层(从1开始)开始折纸n次；down=true代表凹，=false代表凸
    private static void printProcess(int level, int n, boolean down) {
        // base case:层数大于原本N最多折的层数
        if (level > n) {
            return;
        }
        printProcess(level + 1, n, true);
        System.out.print(down ? "凹 " : "凸 ");// 中序遍历，第二次来到=所有的左子树是凹(ture)
        printProcess(level + 1, n, false);// 所有的右子树第一个结点都是凸(false)
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
