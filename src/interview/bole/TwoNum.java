package interview.bole;

import java.util.Arrays;

public class TwoNum {

    public int TwoSum(int[] L, int K) {
        if (L == null || L.length == 0) {
            return -1;
        }
        Arrays.sort(L);
        int left = 0, right = L.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            if (L[left] + L[right] >= K) {
                right--;
            } else {
                res = Math.max(res, L[left] + L[right]);
                left++;
            }
        }
        return res;
    }

    public static int count() {
        int height = -21;
        int count=0;
        while (height < 0) {
            height = height + 10 - 7;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count());
    }


}
