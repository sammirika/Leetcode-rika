package HuisuDigui;

/***
 * 在二维网格 grid 上，有 4 种类型的方格：
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 *  
 *
 * 示例 1：
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 * *****/
public class uniquePathsIII_980 {

    private int m;
    private int n;

    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        // 定义起点
        int x = 0;
        int y = 0;
        // 统计的需要走过的方块数目
        int blockCount = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] == 0) {
                    blockCount++;
                }
            }
        }
        return dfs(x, y, blockCount, grid);
    }

    private int dfs(int x, int y, int step, int[][] grid) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1) {
            return 0;
        }
        // 到达终点,对走过的0块判断
        if (grid[x][y] == 2) {
            return step == 0 ? 1 : 0;
        }
        int res = 0;
        // 走过的标记为路障
        grid[x][y] = -1;
        res += dfs(x - 1, y, step - 1, grid);
        res += dfs(x + 1, y, step - 1, grid);
        res += dfs(x, y - 1, step - 1, grid);
        res += dfs(x, y + 1, step - 1, grid);
        //回溯
        grid[x][y] = 0;
        return res;
    }
}
