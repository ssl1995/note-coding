package 牛客.NC156_数组中只出现一次的数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 哈希map
    public int foundOnceNumber1(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, k);// 条件k>1.多次出现的直接存成k次
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 位运算
    public int foundOnceNumber2(int[] arr, int k) {
        int[] bitArr = new int[32];
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;// 记录arr中每个数在i位置出现的次数
            for (int j = 0; j < arr.length; j++) {
                bitSum += (arr[j] >> i) & 1;// 右移num，同1相与
            }
            bitArr[i] = bitSum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 出现k次的数，在二进制位上1出现的次数%k==0；说明出现一次的数，在该位就是0，不是出现一次的数的二进制位
            // 出现k次的数，在二进制位上1出现的次数%k!=0；说明出现一次的数，在该位就是1，该位置就是出现一次的数的二进制位
            if (bitArr[i] % k != 0) {
                res += 1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 1, 5, 1, 5};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.foundOnceNumber1(arr, k));
        System.out.println(solution.foundOnceNumber2(arr, k));
    }
}
