package 读书笔记.数据结构By慕课网.递归;


public class GetMax {
    // 学习递归
    public static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;
        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr ={1,2,111,4};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}
