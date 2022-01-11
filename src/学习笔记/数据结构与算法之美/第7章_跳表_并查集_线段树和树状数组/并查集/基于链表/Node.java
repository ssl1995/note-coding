package 学习笔记.数据结构与算法之美.第7章_跳表_并查集_线段树和树状数组.并查集.基于链表;

/**
 * @author SongShengLin
 * @date 2022/1/12 1:06 AM
 * @description
 */
public class Node {

    //    public int val;
    public Node pre = this;
    public Node next = this;
    /**
     * 并查集中指向集合头的指针
     */
    public Node R = this;

//    public Node(int val) {
//        this.val = val;
//    }


}
