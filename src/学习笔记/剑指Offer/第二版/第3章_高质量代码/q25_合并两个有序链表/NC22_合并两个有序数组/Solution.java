package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q25_合并两个有序链表.NC22_合并两个有序数组;


public class Solution {
    // 方法1：从前往后遍历
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int p = 0;
        int q = 0;
        for (int i = 0; i < m + n; i++) {
            if (p >= m) {// 注意：或者>m-1
                temp[i] = B[q++];
            } else if (q >= n) {// 注意：或者>n-1
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

    // 方法2：利用A足够大，从后往前遍历，无需辅助数组
    public void merge1(int A[], int m, int B[], int n) {
        int p = m - 1;// 从A的m-1开始往前遍历
        int q = n - 1;// 从B的n-1开始往前遍历
        int i = m + n - 1;// 因为A足够大，从A的m+n-1往前遍历
        while (p >= 0 && q >= 0) {
            A[i--] = A[p] >= B[q] ? A[p--] : B[q--];
        }
        // p<0，说明A中元素较大一直没法移动q，若B中还有元素，就从后到前依次放回A中
        // 如：A=[4,0,0,0] B=[1,2,3]
        while (q >= 0) {
            A[i--] = B[q--];
        }
        // q<0，说明A中元素较小一直无法移动p，此时q遍历完毕，q中元素是A提前排好序的，无需修改
        // 如：A=[1,0,0,0] B=[2,3,4]
    }
}
