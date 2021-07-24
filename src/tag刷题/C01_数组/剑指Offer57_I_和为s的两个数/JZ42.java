package tag刷题.C01_数组.剑指Offer57_I_和为s的两个数;

import java.util.ArrayList;

public class JZ42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (left < right) {
            int temp = array[left] + array[right];
            if (temp < sum) {
                left++;
            } else if (temp > sum) {
                right--;
            } else if (temp == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JZ42 jz42 = new JZ42();
        int[] arr = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        System.out.println(jz42.FindNumbersWithSum(arr, sum));
    }
}
