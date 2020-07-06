package formalMap;

public class Dijkstra {

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] edge = new int[][]{{0,  1, 2,  1},
                                   {INF,0,INF,INF},
                                   {INF,3, 0,  1},
                                   {INF,1, 1,  0}};
        int[] dis = dijkstra(2,edge);
        for (int A:dis){
            System.out.print(A + " ");
        }
    }


    //给一个邻接矩阵和一个点的值，求出最短距离数组，这个图是一个有向有权图
    private static int[] dijkstra(int value, int[][] edge){
        int len = edge.length;
        if (value<0 || value>=len){
            throw new ArrayIndexOutOfBoundsException();
        }
        //最短距离数组
        int[] dis = new int[len];
        //顶点st判断数组
        boolean[] st = new boolean[len];
        for (int i=0;i<len;i++){
            dis[i] = edge[value][i];
        }
        //这个点自己肯定是true
        st[value] = true;
        dis[value] = 0;
        //贪心求最短距离集合
        int index = 0;
        for (int i=0;i<len;i++){
            //每次的最短距离
            int min = Integer.MAX_VALUE;
            for (int j=0;j<len;j++){
                //st来控制是否已经在集合中
                if (dis[j]<min && !st[j]){
                    min = dis[j];
                    index = j;
                }
            }
            st[index] = true;
            for (int m=0;m<len;m++){
                int res = edge[index][m]==Integer.MAX_VALUE? Integer.MAX_VALUE:(min+edge[index][m]);
                if (res<dis[m] && !st[m]){
                    dis[m] = res;
                }
            }
        }
        return dis;
    }
}
