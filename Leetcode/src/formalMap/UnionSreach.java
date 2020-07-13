package formalMap;


//并查集通用解法，以朋友圈为例
/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 * ****/
public class UnionSreach {

    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        UnionSreach kobe = new UnionSreach();
        System.out.println(kobe.findCircleNum(M));
    }

    //例题的求解
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
