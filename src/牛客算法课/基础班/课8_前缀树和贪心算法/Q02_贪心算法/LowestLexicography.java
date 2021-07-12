package 牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LowestLexicography {

    // Q:将字符串数组拼接成一个字符串,使得字符串的字典序最小
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 每两个字符串按照以下策略拼接:(a, b) -> ((a + b).compareTo(b + a)),整体就成字典序最小
        Arrays.sort(strs, (a, b) -> ((a + b).compareTo(b + a)));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

    }


    // 力扣386:字典序排数,给定一个整数 n, 返回从 1 到 n 的字典顺序。
    // 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9]
    public List<Integer> lexicalOrder(int n) {
        // Java中优先级队列(小根堆),默认就是字典序排序
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(String.valueOf(i));
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(Integer.valueOf(queue.poll()));
        }
        return res;
    }

}
