package 读书笔记.数据结构By慕课网.栈.练习题;

public interface IStack {
    void push(int data);//向栈中压数据

    int pop();//从栈顶取数据

    int min(); //获取栈中所有数据的最小值

    int max();//获取栈中所有数据的最大值
}
