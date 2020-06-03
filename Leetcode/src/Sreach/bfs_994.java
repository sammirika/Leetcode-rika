package Sreach;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_994 {
    public static void main(String[] args) {
        int[][] res = new int[][]{{0,2}};
        System.out.println(orangesRotting(res));
    }



    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            for (int i=0;i<4;i++){
                int newdx = xy[0] + dx[i];
                int newdy = xy[1] + dy[i];
                if(newdx>=0 && newdx<m && newdy>=0 && newdy<n && grid[newdx][newdy]==1){
                    grid[newdx][newdy] = grid[xy[0]][xy[1]] + 1;
                    queue.add(new int[]{newdx,newdy});
                }
            }
        }
        int res = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    return -1;
                }else{
                    res = Math.max(res,grid[i][j]);
                }
            }
        }
        return res>2?res-2:0;
    }
}
