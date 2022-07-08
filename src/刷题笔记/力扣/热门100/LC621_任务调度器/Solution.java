package 刷题笔记.力扣.热门100.LC621_任务调度器;

/**
 * @author SongShengLin
 * @date 2022/2/27 1:34 PM
 * @description
 */
public class Solution {
    /**
     * 任务调度器
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     * 注意：
     * 1 <= task.length <= 104
     * tasks[i] 是大写英文字母
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n == 0) {
            return tasks.length;
        }
        // map:统计tasks中每个字母出现的次数
        int[] map = new int[26];
        // max:记录最多出现字母的次数
        int max = 0;
        for (char task : tasks) {
            int num = ++map[task - 'A'];
            max = Math.max(max, num);
        }

        // 贪心：找出相同元素数量最大的的元素，它后面紧跟着n个单位时间,让其余字母去填充
        // n=2，max=3次:A__A__Axx
        // 快速计算其中A__A__所需要的时间为(max-1)*(n+1)
        int res = (max - 1) * (n + 1);

        // 此时还剩最后一个Axx没有计算时间间隔
        // 还有多少个与最大出现次数相同字母的个数累加进res
        for (int i = 0; i < 26; i++) {
            if (map[i] == max) {
                res++;
            }
        }
        // 因为如果所有元素都不相同，n随便取，总耗时为数组长度
        // 但是如果元素存在相同的且n>0时，总耗时肯定超过数组长度
        // 综上，取res和数组长度两者的最大值
        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));

    }
}
