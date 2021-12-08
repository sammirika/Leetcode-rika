package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，
 * 或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 */
public class colorBorder_1034 {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int[][] tmp = new int[m][n];
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n) {
                    continue;
                }
                if (grid[x][y] != grid[newDx][newDy]) {
                    continue;
                } else {
                    count++;
                }
                if (tmp[newDx][newDy] != 0) {
                    continue;
                }
                queue.offer(new int[]{newDx, newDy});
            }
            tmp[x][y] = count == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) {
                    tmp[i][j] = grid[i][j];
                }
            }
        }
        return tmp;
    }
}
