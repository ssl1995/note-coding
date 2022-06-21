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
        // 输入：[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]
        // 排序：[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]：第一位相同，就按第二位从低到高排；第一位不相同，就按第一位从高到底排
        // 按照元素 1 进行降序排序，对于每个元素，在其之前的元素的个数，就是大于等于他的元素的数量
        // 而按照第二个元素正向排序，我们希望 k 大的尽量在后面，减少插入操作的次数
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
            // 将排序后的数组第二位作为插入坐标，插入到list中
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
