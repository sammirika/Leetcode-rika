package formalMap;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * <p>
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * <p>
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 * 1
 * / \
 * 2 - 3
 ****/
public class findRedundantConnection_684 {

    public static void main(String[] args) {
        findRedundantConnection_684 kobe = new findRedundantConnection_684();
        int[] nums = kobe.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        for (int num : nums) {
            System.out.println(num);
        }
    }


    //并查算法，每次更新连通的分量数组

    private int[] parent;
    private int[] size;


    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        if (len == 0) {
            return new int[2];
        }
        this.parent = new int[len + 1];
        this.size = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[] num = new int[2];
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                num = new int[]{edge[0], edge[1]};
            }
        }
        return num;
    }

    private boolean union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        //确定已经是连通分量中的一部分
        if (rootp == rootq) {
            return false;
        }
        if (size[rootp] >= size[rootq]) {
            size[rootp]++;
            parent[rootq] = rootp;
        } else {
            size[q]++;
            parent[rootp] = rootq;
        }
        return true;
    }

    private int find(int val) {
        while (parent[val] != val) {
            parent[val] = parent[parent[val]];
            val = parent[val];
        }
        return val;
    }


}
