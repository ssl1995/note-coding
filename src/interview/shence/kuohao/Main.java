package interview.shence.kuohao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Node {
        Character c;
        Integer index;

        public Node() {

        }

        public Node(Character c, Integer index) {
            this.c = c;
            this.index = index;
        }
    }

    public static List<int[]> index(String str) {
        if (str == null || str.equals("")) {
            return new ArrayList<>();
        }
        List<int[]> list = new ArrayList<>();
        char[] cs = str.toCharArray();
        LinkedList<Node> stack = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                stack.push(new Node(cs[i], i));
            } else if (cs[i] == ')') {
                if (!stack.isEmpty() && stack.peek().c == '(') {
                    Node node = stack.pop();
                    list.add(new int[]{node.index, i});
                }
            }
        }
        return list;
    }

    public static int count(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] cs = str.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                stack.push(cs[i]);
            } else if (cs[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s);
//        System.out.println(count(s);
//        List<int[]> list = index(s);
//        for (int[] arr : list) {
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
//        }
    }
}
