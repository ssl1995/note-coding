package 牛客算法课.初级班.课6_二叉树递归套路.Q08_折纸问题;

public class PintAllFolds {
    // 折纸问题:手动模拟,找规律
    public static void printAllFolds(int n) {
        // 根节点:1层，折纸n次，为凹
        printProcess(1, n, true);
    }

    // level：当前第几层；n：总的折纸次数；down：true=凹，false=凸
    private static void printProcess(int level, int n, boolean down) {
        // base case:层数大于原本N最多折的层数
        if (level > n) {
            return;
        }
        // 中序遍历
        // 所有的左子树是凹(ture)
        printProcess(level + 1, n, true);
        System.out.print(down ? "凹 " : "凸 ");
        // 所有的右子树第一个结点都是凸(false)
        printProcess(level + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
