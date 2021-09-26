package 慕课网数据结构.排序.radixSort;

import java.util.Arrays;

public class LSDSort {
    // 参数提供一个len,提示调用者arr中元素等长的长度
    public static void lSDSort(String[] arr, int len) {
        // LSD算法,多用于字符串排序,这里参数直接使用字符串数组;并且LSD只适用于等长字符串
        // LSD:Least significant digital,比如"ABC"中的“C”是低位,“A”是高位
        for (String s : arr) {
            if (s.length() != len) {
                throw new IllegalArgumentException("All Strings' length must be the same.");
            }
        }
        // Java中Char占1个字节=256位,取值范围0-255
        int R = 256;
        int[] cnt = new int[R];
        int[] index = new int[R + 1];
        // 辅助数组
        String[] temp = new String[arr.length];
        // LSD:从每个字符的末尾开始使用计数排序
        for (int i = len - 1; i >= 0; i--) {
            // 每次遍历开始,记录次数前清空cnt
            Arrays.fill(cnt, 0);
            // 记录次数
            for (String s : arr) {
                cnt[s.charAt(i)]++;
            }
            // 记录index数组
            for (int j = 0; j < index.length - 1; j++) {
                index[j + 1] = index[j] + cnt[j];
            }
            // 根据index,将各字符放回temp数组
            for (String s : arr) {
                // index[s.charAt(i)]=是s起始出现的坐标
                temp[index[s.charAt(i)]] = s;
                // 下一次出现的坐标+1
                index[s.charAt(i)]++;
            }
            // 遍历temp赋值给原数组arr
            for (int j = 0; j < arr.length; j++) {
                arr[j] = temp[j];
            }
        }

    }

    public static void main(String[] args) {
        String[] arr = {"a", "c", "d"};
        LSDSort.lSDSort(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

}
