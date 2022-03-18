package 刷题笔记.力扣.代码随想录.C01_数组.LC59_螺旋矩阵II;

/**
 * @author SongShengLin
 * @date 2022/3/19 00:43
 * @description
 */
public class Solution {
    /**
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     */
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] res = new int[n][n];
        // 转圈次数
        int loop = n / 2;

        int x = 0;
        int y = 0;
        // 每一圈循环，每一条边距离n-1位置的长度
        // 左开右闭，第一次遍历偏移量为1
        int offerSet = 1;

        int count = 1;

        while (loop >= 0) {
            int i = x;
            int j = y;

            // 所有边都是左闭右开

            // 上面左到右
            for (; j < y + n - offerSet; j++) {
                res[x][j] = count++;
            }

            // 右边上到下
            for (; i < x + n - offerSet; i++) {
                res[i][j] = count++;
            }

            // 下边右到左
            for (; j > y; j--) {
                res[i][j] = count++;
            }

            // 左边下到上
            for (; i > x; i--) {
                res[i][j] = count++;
            }

            loop--;
            x++;
            y++;

            // 除去第一次遍历量为1，之后均为2
            // 因为每一圈循环，首尾元素都要减去
            offerSet += 2;

        }
        // 如果n是奇数，二维矩阵中间有空，赋值即可
        if ((n & 1) != 0) {
            res[n / 2][n / 2] = count;
        }
        return res;
    }
}
