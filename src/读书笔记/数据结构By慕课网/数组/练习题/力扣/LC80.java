package 读书笔记.数据结构By慕课网.数组.练习题.力扣;

/**
 * LC80. 删除排序数组中的重复项 II
 * 题目：给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 例子:输入：nums = [1,1,1,2,2,3];输出：5, nums = [1,1,2,2,3]
 */
class LC80 {
    // 方法1：i和j从1开始，因为i是遍历指针，j指向下一个要覆盖元素的位置。
    public int removeDuplicates1(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 相等只移动i
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // 不相等就将count置1
                count = 1;
            }
            // j指向下一个需要覆盖的元素，
            // <=2就说明当前元素不用被覆盖，赋值给nums[i]就行
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    // 方法2：count记录出现重复数的次数，超过2就删除
    public int removeDuplicates2(int[] nums) {
        int i = 1, count = 1, n = nums.length;
        while (i < n) {
            // 前后相同元素
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    remElement(nums, i);
                    i--;
                    n--;
                }
            } else {
                // 前后不相同的元素，count置为1
                count = 1;
            }
            i++;
        }
        return n;
    }

    public int[] remElement(int[] arr, int i) {
        for (int j = i; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        return arr;
    }
}
