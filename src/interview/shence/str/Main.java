package interview.shence.str;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(reverseAll(str));
    }


    public static String reverseAll(String s) {
        String trim = s.trim();
        int first = 0;
        int index = 0;
        StringBuilder temp = new StringBuilder();
        while (index < s.length()) {
            while (index < s.length() && trim.charAt(index) != ' ') {
                index++;
            }
            temp.append(reverseOne(s.substring(first, index)));
            temp.append(" ");
            while (index < s.length() && trim.charAt(index) == ' ') {
                index++;
            }
            first = index;
        }
        return temp.toString().trim();
    }

    public static String reverseOne(String s) {
        char[] cs = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            swap(cs, left, right);
            left++;
            right--;
        }
        return new String(cs);
    }

    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
