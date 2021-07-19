package tag刷题.C04_字符串.NC137_表达式求值;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {

    public int solve(String s) {
        String rpn = toSuffix(s);
        return getRPNval(rpn);
    }

    /**
     * 将  中缀表达式  转化为  后缀表达式
     */
    public String toSuffix(String s) {
        Map<Character, Integer> basic = new HashMap<>();
        basic.put('(', 0);//在运算中  （）的优先级最高，但是此处因程序中需要 故设置为0
        basic.put('+', 1);
        basic.put('-', 1);
        basic.put('*', 2);
        basic.put('/', 2);
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<Character> stack = new LinkedList<>();
        char[] cs = s.trim().toCharArray();
        String standard = "*/+-()";
        char ch;
        int len = 0;
        for (int i = 0; i < cs.length; i++) {
            ch = cs[i];
            //保存当前迭代变量
            if (Character.isDigit(ch) || Character.isLetter(ch) || ch == '.') {
                len++;
            } else if (Character.isSpaceChar(ch)) {
                //如果当前变量为 空格  支持表达式中有空格出现
                if (len > 0) {
                    //若为空格 代表 一段结束 ，就可以往队列中  存入了  【例如100 * 2  100后面有空格 就可以将空格之前的存入队列了】
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    //往 队列存入 截取的 字符串
                    len = 0;
                    //长度置空
                }
                continue;
                //如果空格出现，则一段结束  跳出本次循环
            } else if (standard.contains(String.valueOf(ch))) {
                //如果是上面标准中的 任意一个符号
                if (len > 0) {
                    //长度也有
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len, i)));
                    //说明符号之前的可以截取下来做数字
                    len = 0;
                    //长度置空
                }
                if (ch == '(') {
                    //如果是左括号
                    stack.add(ch);
                    //将左括号 放入栈中
                    continue;
                    //跳出本次循环  继续找下一个位置
                }
                if (!stack.isEmpty()) {
                    //如果栈不为empty
                    int size = stack.size() - 1;
                    //获取栈的大小-1  即代表栈最后一个元素的下标
                    boolean flag = false;
                    //设置标志位
                    while (size >= 0 && ch == ')' && stack.get(size) != '(') {
                        //若当前ch为右括号，则 栈里元素从栈顶一直弹出，直到弹出到 左括号
                        queue.add(String.valueOf(stack.remove(size)));
                        //注意此处条件：ch并未入栈，所以并未插入队列中；
                        //同样直到找到左括号的时候，循环结束了，所以左括号也不会放入队列中
                        //【也就是：后缀表达式中不会出现括号】
                        size--;
                        //size-- 保证下标永远在栈最后一个元素【栈中概念：指针永远指在栈顶元素】
                        flag = true;
                        //设置标志位为true  表明一直在取（）中的元素
                    }
                    while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) {
                        //若取得不是（）内的元素，并且当前栈顶元素的优先级>=对比元素 那就出栈插入队列
                        queue.add(String.valueOf(stack.remove(size)));
                        //同样  此处也是remove()方法，既能得到要获取的元素，也能将栈中元素移除掉
                        size--;
                    }
                }
                if (ch != ')') {
                    //若当前元素不是右括号
                    stack.add(ch);
                    //就要保证这个符号 入栈
                } else {
                    //否则就要出栈 栈内符号
                    stack.remove(stack.size() - 1);
                }
            }
            if (i == cs.length - 1) {
                //如果已经走到了  中缀表达式的最后一位
                if (len > 0) {
                    //如果len>0  就截取数字
                    queue.add(String.valueOf(Arrays.copyOfRange(cs, i - len + 1, i + 1)));
                }
                int size = stack.size() - 1;
                //size表示栈内最后一个元素下标
                while (size >= 0) {
                    //一直将栈内  符号全部出栈 并且加入队列中
                    //【最终的后缀表达式是存放在队列中的，而栈内最后会被弹空】
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }


    public int getRPNval(String equation) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] rpnString = equation.split(",");
        int a, b;
        for (int i = 0; i < rpnString.length; i++) {
            String c = rpnString[i];
            if (c.equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.add(b + a);
            } else if (c.equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.add(b - a);
            } else if (c.equals("*")) {
                a = stack.pop();
                b = stack.pop();
                stack.add(b * a);
            } else if (c.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }
}

