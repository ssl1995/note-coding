package 牛客算法课.初级班.课5_链表的环形问题和二叉树;

public class PintAllFolds {
    public static void printAllFolds(int n) {
        // 根节点:1层，折纸n次，为凹
        printProcess(1, n, true);
    }

    // level：当前第几层；n：总的折纸次数；down：true=凹，false=凸
    private static void printProcess(int level, int n, boolean down) {
        if (level > n) {
            return;
        }
        printProcess(level + 1, n, true);
        System.out.print(down ? "凹 " : "凸 ");
        printProcess(level + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
