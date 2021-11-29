package 剑指Offer.专项突击版.第12章_排序.q75_数组相对排序;

/**
 * @author SongShengLin
 * @date 2021/11/8 8:56 上午
 * @description
 */
public class Solution {
    // 0 <= arr1[i], arr2[i] <= 1000提示用计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        for (int j = 0; j < counts.length; j++) {
            while (counts[j] > 0) {
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}
