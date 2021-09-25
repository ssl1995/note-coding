package 慕课网数据结构.排序.bubbleSort.剑指offer45;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String minNumber(int[] nums) {
        // 用list存储String
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            // 将nums中的值转换为String存储进list
            list.add(String.valueOf(num));
        }
        // 拼接数组内所有元素使结果最小，本质上是排序
        // 若字符串拼接 a + b > b + a，那么排序上 b < a;
        list.sort((a, b) -> (a + b).compareTo(b + a));
        // 用res接受结果字符串
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            res.append(str);
        }
        return res.toString();
    }
}
