package 慕课网数据结构.树.字典树;

public class TrieByZuo {
    private TrieNode root;

    public TrieByZuo() {
        root = new TrieNode();

    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        // 1.将字符串转变为字符数组
        char[] chs = word.toCharArray();
        TrieNode node = root;//遍历指针
        // node.path++; //好像是书中的刊物
        int index = 0;// 字符应该在数组中索引
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        // 保证单词存在的话，就进行删除，最坏情况末尾才到该单词结束
        if (search(word)) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char ch : chs) {
                index = ch - 'a';
                // 如果当前节点-1为0，后续就全部删除
                if (--(node.map[index].path) == 0) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            // 上面循环跳出，说明node指向树形结构末尾
            // 在单词存在的情况，末尾元素就是该word，于是end--
            node.end--;
        }
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chs = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
}
