package Sreach;

import java.util.LinkedList;
import java.util.Queue;

public class dfs_576 {
    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }

    public static int findPaths(int m, int n, int N, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        queue.add(new int[]{i,j});
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int[][] dis = new int[m][n];
        dis[i][j] = 0;
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            for(int a=0;a<4;a++){
                int newdx = xy[0] + dx[a];
                int newdy = xy[1] + dy[a];
                if((newdx<0 || newdx>=m || newdy<0 || newdy>=n) &&
                        dis[xy[0]][xy[1]]<N ){
                    res++;
                }else if(dis[xy[0]][xy[1]]<N && newdx>=0 && newdx<=m-1 && newdy>=0
                        && newdy<=n-1 ){
                    queue.add(new int[]{newdx,newdy});
                    dis[newdx][newdy] = dis[xy[0]][xy[1]] + 1;
                }
            }
        }
        return res%(1000000000+7);
    }
}
