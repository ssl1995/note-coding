package interview.wangyi.Q2_寻找k位;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Character> map;

    public char findKthBit(int n, int k) {
        map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.put(4, 'd');
        map.put(5, 'e');
        map.put(6, 'f');
        map.put(7, 'g');
        map.put(8, 'h');
        map.put(9, 'i');
        map.put(10, 'j');
        map.put(11, 'k');
        map.put(12, 'l');
        map.put(13, 'm');
        map.put(14, 'n');
        map.put(15, 'o');
        map.put(16, 'p');
        map.put(17, 'q');
        map.put(18, 'r');
        map.put(19, 's');
        map.put(20, 't');
        map.put(21, 'u');
        map.put(22, 'v');
        map.put(23, 'w');
        map.put(24, 'x');
        map.put(25, 'y');
        map.put(26, 'z');
        return process(n, k, map);
    }

    private char process(int n, int k, HashMap<Integer, Character> map) {
        if (k == 1) {
            return 'a';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return map.get(mid);
        } else if (k < mid) {
            return process(n - 1, k, map);
        } else {
            k = mid * 2 - k;
            return invert(process(n - 1, k, map));
        }

    }

    private  char invert(char c) {
        return map.get(26 - (c - 'a'));
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 11;
        System.out.println( 1 << (n - 1));
        Solution solution = new Solution();
        System.out.println(solution.findKthBit(n, k));
    }


}
