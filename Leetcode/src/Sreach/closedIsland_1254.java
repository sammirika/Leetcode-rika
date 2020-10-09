package Sreach;


/**
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 * 示例 1：
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 *
 * ****/
public class closedIsland_1254 {

    private int m;
    private int n;
    private int count = 0;
    public int closedIsland(int[][] grid) {
        this.m = grid.length;
        if (m == 0){
            return 0;
        }
        this.n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        // 先对周边进行递归，排除不可能封闭的情况
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                // 四条边的陆地递归
                if (grid[i][j] == 0 && (i==0 || j==0||i==m-1||j==n-1)){
                    dfs(i,j,grid,visit);
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 0){
                    count++;
                    dfs(i,j,grid,visit);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, int[][] grid,boolean[][] visit){
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] == 1 || visit[i][j]){
            return;
        }
        // 标记为水
        visit[i][j] = true;
        grid[i][j] = 1;
        //上下左右递归
        dfs(i-1,j,grid,visit);
        dfs(i+1,j,grid,visit);
        dfs(i,j-1,grid,visit);
        dfs(i,j+1,grid,visit);
    }
}
