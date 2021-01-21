package Sreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，
 * 其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。
 * 最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，
 * 那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * <p>
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 * 示例 1：
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 ***/
public class findCriticalAndPseudoCriticalEdges_1489 {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        UnionFind unionFind = new UnionFind(n);
        int value = 0;
        for (int i = 0; i < len; i++) {
            if (unionFind.union(newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            UnionFind uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < len; j++) {
                if (i != j && uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (uf.Count != 1 || (uf.Count == 1 && v > value)) {
                lists.get(0).add(newEdges[i][3]);
                continue;
            }
            uf = new UnionFind(n);
            uf.union(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < len; j++) {
                if (i != j && uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                lists.get(1).add(newEdges[i][3]);
            }
        }
        return lists;
    }

    class UnionFind {
        private int[] parent;
        private int[] size;
        private int Count;

        public UnionFind(int n) {
            this.Count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (size[rootX] >= size[rootY]) {
                parent[rootY] = rootX;
                size[rootX]++;
            } else {
                parent[rootX] = rootY;
                size[rootY]++;
            }
            Count--;
            return true;
        }
    }
}
