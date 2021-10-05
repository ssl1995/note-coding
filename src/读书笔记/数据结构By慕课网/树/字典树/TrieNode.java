package 读书笔记.数据结构By慕课网.树.字典树;

public class TrieNode {
    public int path;// 表示经过了多少个当前节点
    public int end;// 表示有多少个单词以该节点结尾
    public TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        // 字典序长度为26个字符
        map = new TrieNode[26];
    }
}
