package formalMap;

/**
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * 示例 1:
 * * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * 示例 2:
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 **/
public class findRedundantDirectedConnection_685 {

    //在一课树中随机添加一条边，可能构成环可能不构成环，找到入度为2的点进行并查判断
    private int[] parent;
    private int doubleRoot = 0;
    // 保存环中的最后一条边的两个点
    private int[] res = new int[2];
    // 保存入度为2的两条边
    private int[][] resSide = new int[2][2];
    //保存每个点的入度
    private int[] inDegree;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        this.parent = new int[len + 1];
        this.inDegree = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
            if (inDegree[edge[1]] == 2) {
                doubleRoot = edge[1];
                resSide[1] = edge;
            } else {
                union(edge[0], edge[1]);
            }
        }
        // 存在入度为2的点
        if (doubleRoot != 0) {
            for (int[] edge : edges) {
                if (edge[1] == doubleRoot) {
                    resSide[0] = edge;
                    break;
                }
            }
            int root = 0;
            for (int i = 1; i <= len; i++) {
                if (root == 0) {
                    root = find(i);
                }
                if (root != find(i)) {
                    return resSide[0];
                }
            }
            return resSide[1];
        }
        return res;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootQ] = rootP;
        } else {
            res[0] = p;
            res[1] = q;
        }
    }

    private int find(int val) {
        while (parent[val] != val) {
            parent[val] = parent[parent[val]];
            val = parent[val];
        }
        return val;
    }
}
