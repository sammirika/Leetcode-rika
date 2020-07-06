package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 *
 * *******/
public class uniquePathsWithObstacles_63 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }

    //bfs求解
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = obstacleGrid.length;
        if (m==0){
            return 0;
        }
        int n= obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1){
            return 0;
        }
        queue.add(new int[]{0,0});
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        int[][] res = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        res[0][0] = 1;
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            for (int i=0;i<2;i++){
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx>=0 && newDx<m && newDy>=0 && newDy<n && obstacleGrid[newDx][newDy]==0){
                    res[newDx][newDy] += res[xy[0]][xy[1]];
                    if (!visit[newDx][newDy]){
                        queue.add(new int[]{newDx,newDy});
                        visit[newDx][newDy] = true;
                    }
                }
            }
        }
        return res[m-1][n-1];
    }

    //当然也可以DP
    public int uniquePathsWithObstacles2(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int [m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                if(i==0&&j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
