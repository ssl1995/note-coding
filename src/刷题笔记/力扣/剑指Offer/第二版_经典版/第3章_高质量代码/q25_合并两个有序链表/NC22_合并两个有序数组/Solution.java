package 刷题笔记.力扣.剑指Offer.第二版_经典版.第3章_高质量代码.q25_合并两个有序链表.NC22_合并两个有序数组;

public class Solution {
    /**
     * 合并两个有序数组
     * 方法1：从前往后遍历
     */
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int p = 0;
        int q = 0;
        for (int i = 0; i < m + n; i++) {
            if (p >= m) {
                temp[i] = B[q++];
            } else if (q >= n) {
                temp[i] = A[p++];
            } else if (A[p] <= B[q]) {
                temp[i] = A[p++];
            } else {
                temp[i] = B[q++];
            }
        }
        // System.arraycopy(原数组，原数组起始坐标，目标数组，目标数组起始坐标，原数组复制的长度)
        System.arraycopy(temp, 0, A, 0, m + n);
    }

    /**
     * 方法2：利用A足够大，从后往前遍历，无需辅助数组
     */
    public void merge1(int A[], int m, int B[], int n) {
        int p = m - 1;
        int q = n - 1;
        int i = m + n - 1;
        while (p >= 0 && q >= 0) {
            // 从后往前放，是放较大的数
            A[i--] = A[p] >= B[q] ? A[p--] : B[q--];
        }
        // 若p>=0，原先A=[1,0,0,0],B=[2,3,4],此时A=[1,2,3,4],无序再改变结果
        // 若q>=0，原先A=[4,0,0,0],B=[1,2,3],此时A=[4,0,0,4],还需要移动B来覆盖A中的数据
        while (q >= 0) {
            A[i--] = B[q--];
        }
    }
}
