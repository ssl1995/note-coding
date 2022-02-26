package 刷题笔记.力扣.热门100.LC406_根据身高重建序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/25 8:20 AM
 * @description
 */
public class Solution {
    /**
     * 根据身高重建序列
     * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * 解释：
     * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][]{};
        }
        // [7,0],[7,1]：第一位从高到底，保证后面的没他高 且 如果 高度相同，按第二位从低到高排序
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> list = new ArrayList<>();

        /** res 过程！
         *  7-0
         *  7-0，7-1
         *  7-0，6-1，7-1
         *  5-0，7-0，6-1，7-1
         *  5-0，7-0，5-2，6-1，7-1
         *  5-0，7-0，5-2，6-1，4-4，7-1
         */
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] num = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue(num)));
    }

}
