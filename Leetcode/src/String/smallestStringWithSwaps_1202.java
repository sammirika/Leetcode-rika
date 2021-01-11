package String;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，
 * 其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 **/
public class smallestStringWithSwaps_1202 {

    // 并查解决
    private int[] parent;
    private int[] weight;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        this.parent = new int[len];
        this.weight = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
        // 开始并查
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        // 并查结束后开始字典排序
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int root = find(i);
            if (map.containsKey(root)) {
                map.get(root).add(s.charAt(i));
            } else {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.add(s.charAt(i));
                map.put(root, queue);
            }
        }

        // 重组字符串
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = find(i);
            str.append(map.get(root).poll());
        }
        return str.toString();

    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (weight[rootX] > weight[rootY]) {
            parent[rootY] = rootX;
            weight[rootX]++;
        } else {
            parent[rootX] = rootY;
            weight[rootY]++;
        }
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
