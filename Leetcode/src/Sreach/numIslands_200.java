package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * ***/
public class numIslands_200 {


    int row;
    int col;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};


    //bfs解法
    public int numIslands(char[][] grid) {
        this.row = grid.length;
        if (row == 0) {
            return 0;
        }
        this.col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(int x, int y, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newDx = dx[i] + xy[0];
                int newDy = dy[i] + xy[1];
                if (newDx >= 0 && newDy >= 0 && newDx < row && newDy < col && grid[newDx][newDy] == '1') {
                    grid[newDx][newDy] = '0';
                    queue.add(new int[]{newDx, newDy});
                }
            }
        }
    }


    //dfs解法，每次遍历到一个'1'就把'1'周围的'1'编程’0‘
    public int numIslands1(char[][] grid) {
        this.row = grid.length;
        if (row==0){
            return 0;
        }
        this.col = grid[0].length;
        int res = 0;
        boolean[][] visit = new boolean[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j] =='1'){
                    dfs(i,j,grid,visit);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int x,int y, char[][] grid, boolean[][] visit){
        if (visit[x][y]){
            return;
        }
        visit[x][y] = true;
        for (int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //每次标记一个陆地为水
            if (nx>=0 && ny>=0 && nx<row && ny<col && grid[nx][ny]=='1'){
                grid[nx][ny] = '0';
                dfs(nx,ny,grid,visit);
            }
        }
    }
}
