package formalMap;


/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 *
 *  
 *
 * 示例 1：
 *图在image
 *
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * ******/
public class makeConnected_1319 {
    //根结点数组
    private int[] parent;
    //权重数组
    private int[] size;

    //连通分量
    private int count;

    public static void main(String[] args) {
        makeConnected_1319 kobe = new makeConnected_1319();
        int[][] nums = new int[][]{{0,1},{0,2},{1,2}};
        System.out.println(kobe.makeConnected(4,nums));
    }

    //可以看成求连通分量的问题
    public int makeConnected(int n, int[][] connections) {
        //线长
        int line = connections.length;
        //n个主机必须要n-1根线
        if (line<n-1){
            return -1;
        }
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] connection:connections){
            union(connection[0],connection[1]);
        }
        //返回连通分量个数减一
        return count-1;
    }

    //union函数
    private void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootp==rootq){
            return;
        }
        if (size[rootp]>=size[rootq]){
            parent[rootq] = rootp;
        }else {
            parent[rootp] = rootq;
        }
        count--;
    }

    //find 函数
    private int find(int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
            x= parent[x];
        }
        return x;
    }
}
