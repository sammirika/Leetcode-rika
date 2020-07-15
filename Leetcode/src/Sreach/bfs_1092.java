package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 *
 * 输出：2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ****/

public class bfs_1092 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if (m==0){
            return 0;
        }
        int n = grid[0].length;
        //排除特殊情况
        if (grid[m-1][n-1] == 1 || grid[0][0] == 1){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        //上下左右加上四个对角线
        int[] dx = new int[]{-1,1,0,0,-1,-1,1,1};
        int[] dy = new int[]{0,0,-1,1,-1,1,-1,1};
        boolean[][] visit = new boolean[m][n];
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            //到达终点
            if (xy[0] == m-1 && xy[1] == n-1){
                return grid[xy[0]][xy[1]];
            }
            for (int i=0;i<8;i++){
                int newDx = xy[0] + dx[i];
                int newDY = xy[1] + dy[i];
                if (newDx<0 || newDx>=m || newDY<0 || newDY>=n || visit[newDx][newDY] || grid[newDx][newDY]!=0){
                    continue;
                }
                grid[newDx][newDY] = grid[xy[0]][xy[1]] + 1;
                queue.add(new int[]{newDx,newDY});
            }
        }
        return -1;
    }
}
