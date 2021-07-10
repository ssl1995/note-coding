package 牛客算法课.初级班.课7_图的遍历和最小生成树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LowestLexicography {

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
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


    // 力扣386
    public List<Integer> lexicalOrder(int n) {
        // 优先级队列默认小根堆
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
