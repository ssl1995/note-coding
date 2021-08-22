package interview.wangyi.Q1_数组中小于等于M的组合数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int process(int[] arr, int m) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int other = m - arr[i];
            for (int j = 0; j < arr.length && i != j; j++) {
                if (arr[j] <= other) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner2 = new Scanner(s);
        while (scanner2.hasNext()) {
            list.add(scanner2.nextInt()); //将字符串转换为数字并存储进数组中
        }
        scanner2.close();
        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
//        System.out.println("arr:" + Arrays.toString(arr));
        int m = scanner.nextInt();
//        System.out.println("m:" + m);
        System.out.println(process(arr, m));
    }
}
