package 慕课网数据结构.排序.countSort.力扣75_颜色分类;


public class Solution {

    // 方法1:简单的记录出现元素次数，但对于理解计数排序法非常有帮助
    public void sortColors1(int[] nums) {
        // count数组记录0,1,2在nums中出现的次数
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        // 注意下标之间的连接
        for (int i = 0; i < count[0]; i++) {
            nums[i] = 0;
        }
        for (int i = count[0]; i < count[1] + count[0]; i++) {
            nums[i] = 1;
        }
        for (int i = count[1] + count[0]; i < count[2] + count[1] + count[0]; i++) {
            nums[i] = 2;
        }
    }

    // 方法2:计数排序法
    public void sortColors2(int[] nums) {
        // 1.定义元素取值范围:(0,1,2)=数组长度3
        int R = 3;
        int[] cnt = new int[R];
        // 记录出现的次数
        for (int num : nums) {
            cnt[num]++;
        }
        // 2.index表示:nums排好序后[index[i],index[i+1])的值为i
        // 因为0之前没有元素，单独用0位置存，所以是R+1个长度
        int[] index = new int[R + 1];
        // 遍历R次,记录每次的i的index数组
        for (int i = 0; i < R; i++) {
            index[i + 1] = index[i] + cnt[i];
        }
        // 3.再次遍历index数组，将数据返回nums中
        for (int i = 0; i < R; i++) {
            // nums[index[i],index[i+1])=i
            for (int j = index[i]; j < index[i + 1]; j++) {
                nums[j] = i;
            }
        }
    }
}
