package interview.shence.count;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int count = 0;

    private static void process(int x, int y, int m) {
        if (x >= m || y >= m || (x + y <= 0 && m > 0) || (x + y >= 0 && m < 0) || x + y >= m) {
            return;
        }
        count++;
        process(x + y, y, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                list.add(s.charAt(i) - '0');
            }
        }
        int x = list.get(0);
        int y = list.get(1);
        int m = list.get(2);
        process(x, y, m);
        System.out.println(count == 0 ? -1 : count);
    }
}
