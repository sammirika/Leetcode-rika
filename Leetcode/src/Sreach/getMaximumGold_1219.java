package Sreach;

/**
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
 * 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 * [5,8,7],
 * [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 */
public class getMaximumGold_1219 {
    // 回溯
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int m, n;
    private int[][] grid;
    private int ret = 0;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return ret;
    }

    private void dfs(int x, int y, int gold) {
        gold += grid[x][y];
        ret = Math.max(ret, gold);
        int back = grid[x][y];
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newDx = x + dx[i];
            int newDy = y + dy[i];
            if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n && grid[newDx][newDy] != 0) {
                dfs(newDx, newDy, gold);
            }
        }
        grid[x][y] = back;
    }
}
