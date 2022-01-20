package 刷题笔记.力扣.编号刷题.LC763_划分字母区间;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/10/11 9:28 下午
 * @description
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        // ASCII小写字母:a:97-z:122,最大下标到123
        int[] edge = new int['z' + 1];
        char[] cs = s.toCharArray();
        // 统计每一个字符最后出现的位置
        for (int i = 0; i < cs.length; i++) {
            edge[cs[i]] = i;
        }
        int maxIndex = 0;
        int last = -1;
        // 从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
        for (int i = 0; i < cs.length; i++) {
            maxIndex = Math.max(maxIndex, edge[cs[i]]);
            if (i == maxIndex) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        char[] cs = new char['z' + 1];
        System.out.println(cs.length);
    }
}
