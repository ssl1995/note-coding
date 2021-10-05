package 读书笔记.数据结构By慕课网.排序.countSort.力扣1122_数组的相对排序;

public class Solution {
    /*
        题目:给你两个数组，arr1 和arr2，
        arr2中的元素各不相同
        arr2 中的每个元素都出现在arr1中
        对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。

        输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        输出：[2,2,2,1,4,3,3,9,6,7,19]
     */

    // 计数排序法,取值范围为[0,1000]所以可以考虑使用计数排序法
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 1.找到arr1中最大值max,生成count[max+1]，count[0,max]记录arr1每个元素出现次数
        int max = 0;
        for (int num : arr1) {
            max = Math.max(num, max);
        }
        // 2.只用计数排序中的count数组记录次数就行,不需要index数组
        int[] count = new int[max + 1];
        for (int num : arr1) {
            count[num]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        // 3.遍历arr2中元素,回count[num]=出现次数,放回res中
        for (int num : arr2) {
            for (int i = 0; i < count[num]; i++) {
                res[index++] = num;
            }
            // 重点:用过的count[num]清零,说明
            count[num] = 0;
        }
        // 4.遍历count,非0元素遍历个数回res中
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    res[index++] = i;
                }
            }
        }
        return res;
    }
}
