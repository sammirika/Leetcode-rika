package Sreach;


import java.util.Arrays;
import java.util.Comparator;

/***
 * 想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
 * 给你一些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 
 * 表示将城市 city1 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市
 * city1 和城市 city2 相连也同样意味着城市 city2 和城市 city1 相连）。
 * 返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。该最小成本应该是所用全部连接代价的综合。
 * 如果根据已知条件无法完成该项任务，则请你返回 -1。
 *
 * 示例 1：
 *
 * 输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：
 * 选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 *
 * ****/
public class minimumCost_1135 {

    private int[] parent;
    private int count = 1;
    // 并查集朴素解法
    public int minimumCost(int N, int[][] connections) {
        // 先对数组进行排序
        this.parent = new int[N+1];
        // 森林赋初值
        for (int i=1;i<=N;i++){
            parent[i] = i;
        }
        // 以cost值升序排序
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int cost = 0;
        for (int[] collection:connections){
            int x = collection[0];
            int y = collection[1];
            int z = collection[2];
            if (find(x) == find(y)){
                continue;
            }
            cost += z;
            union(x,y);
            count++;
            // 合并N次代表已经包含了所有的点
            if (count == N){
                return cost;
            }
        }
        return -1;
    }

    // union,直接让根p变成根q的父亲节点
    private void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootp != rootq){
            parent[rootq] = rootp;
        }
    }

    // find这里就找一次父节点不用路径压缩
    private int find(int val){
        while (parent[val] != val){
            parent[val] = parent[parent[val]];
            val = parent[val];
        }
        return val;
    }
}
