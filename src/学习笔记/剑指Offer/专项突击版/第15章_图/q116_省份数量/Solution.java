package 学习笔记.剑指Offer.专项突击版.第15章_图.q116_省份数量;

/**
 * @author SongShengLin
 * @date 2021/11/28 10:56 下午
 * @description
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] fathers = new int[isConnected.length];
        // 并查集初始化，所有结点父节点先指向自己
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        // 朋友圈数量为行数
        int count = isConnected.length;
        // isConnected[i][j]==1表示为直接朋友，自己也自己必为朋友，说明是对称的
        for (int i = 0; i < isConnected.length; i++) {
            // 只有访问下三角即可，因为朋友关系在二维数组中是对称的
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }

    /**
     * 合并i和j所在子图
     */
    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            // 合并两个子集
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    /**
     * 查找一个结点i的根节点
     */
    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            // 压缩路径，记录每个结点的根节点
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }
}
