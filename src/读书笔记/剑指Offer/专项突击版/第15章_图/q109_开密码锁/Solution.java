package 读书笔记.剑指Offer.专项突击版.第15章_图.q109_开密码锁;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/26 9:03 上午
 * @description
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        String init = "0000";
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        int steps = 0;
        queue1.offer(init);
        visited.add(init);

        while (!queue1.isEmpty()) {
            String cur = queue1.remove();
            if (cur.equals(target)) {
                return steps;
            }

            List<String> nexts = getNeighbors(cur);
            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    queue2.add(next);
                    visited.add(next);
                }
            }

            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }


    /**
     * 向上/向下拨动某个密码，获取所有可能性的字符串
     * 比如0000，向上/向下拨动一位，有8种可能性
     *
     * @param cur 密码锁：比如"0000"
     * @return 所有可能性的字符串
     */
    private List<String> getNeighbors(String cur) {
        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);
            StringBuilder sb = new StringBuilder(cur);

            char newCh = (ch == '0') ? '9' : (char) (ch - 1);
            sb.setCharAt(i, newCh);
            nexts.add(sb.toString());

            newCh = (ch == '9') ? '0' : (char) (ch + 1);
            sb.setCharAt(i, newCh);
            nexts.add(sb.toString());
        }

        return nexts;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String target = "0202";
        String target = "0009";
        String[] deadStr = {"8888"};
        System.out.println(solution.openLock(deadStr, target));
    }
}
