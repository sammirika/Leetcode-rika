package Sreach;

import java.util.HashMap;
import java.util.Map;

public class removeStones_947 {

    /***
     * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
     * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
     * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，
     * 返回 可以移除的石子 的最大数量。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * 输出：5
     * 解释：一种移除 5 块石头的方法如下所示：
     * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
     * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
     * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
     * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
     * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
     * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
     * **/
    private int[] parent;
    private int[] weight;
    private int count;

    public int removeStones(int[][] stones) {
        int len = stones.length;
        this.parent = new int[len];
        this.weight = new int[len];
        this.count = len;
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = i;
            int[] stone = stones[i];
            // 在之前的点中包含直接返回为之前的点的index值
            int rootX = row.computeIfAbsent(stone[0], e -> temp);
            int rootY = col.computeIfAbsent(stone[1], e -> temp);
            union(i, rootX);
            union(i, rootY);
        }
        return len - count;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (weight[rootX] >= weight[rootY]) {
            parent[rootY] = rootX;
            weight[rootX]++;
        } else {
            parent[rootX] = rootY;
            weight[rootY]++;
        }
        count--;
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
