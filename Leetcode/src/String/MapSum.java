package String;

import java.util.TreeMap;

/***
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 * 如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 */
public class MapSum {

    private class Node {
        private int val;
        private TreeMap<Character, Node> next;

        public Node(int val) {
            this.val = val;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    /**
     * Initialize your data structure here.
     */
    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (cur.next.get(ch) == null) {
                cur.next.put(ch, new Node());
            }
            cur = cur.next.get(ch);
        }
        // 最后一个节点代表value
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.next.get(ch) == null) {
                return 0;
            }
            cur = cur.next.get(ch);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.val;
        for (char ch : node.next.keySet()) {
            res += sum(node.next.get(ch));
        }
        return res;
    }
}
