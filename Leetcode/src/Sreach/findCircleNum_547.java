package Sreach;


/***
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。 
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * ***/
public class findCircleNum_547 {

    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i=0;i<M.length;i++){
            for (int j=i-1;j>=0;j--){
                if (M[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }

    //并查算法,排查图中一共有几个独立连通量
    class UnionFind{
        //前驱节点数组，也就是父节点数组
        private int[] parent;
        //树重量数组，用于构建平衡的树
        private int[] size;
        //连通变量
        private int count;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i=0;i<n;i++){
                //每个点的父节点初始化时是自己
                parent[i] = i;
                //每一个节点目前的重量都是1
                size[i] = 1;
            }
        }

        //合并函数
        private void union(int p, int q){
            int rootp = find(p);
            int rootq = find(q);
            if (rootp==rootq){
                return;
            }
            if (size[rootp]>size[rootq]){
                parent[rootq] = rootp;
                size[rootp] += size[rootq];
            }else {
                parent[rootp] = rootq;
                size[rootq] += size[rootp];
            }
            //每合并一次连通分量减一
            count--;
        }

        //寻找函数,每次都要找到这个节点的父亲节点
        private int find(int x){
            while (parent[x]!=x){
                //路径压缩，降低高度
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        //返回连通分量
        public int Getcount(){
            return count;
        }
    }
}
