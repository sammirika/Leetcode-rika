package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 */
public class numEnclaves_1020 {

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int countOne = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    countOne++;
                }
                // 边界点入队
                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            ret++;
            for (int i = 0; i < 4; i++) {
                int newDx = dx[i] + xy[0];
                int newDy = dy[i] + xy[1];
                if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n &&
                        grid[newDx][newDy] == 1 && !visit[newDx][newDy]) {
                    queue.offer(new int[]{newDx, newDy});
                    visit[newDx][newDy] = true;
                }
            }
        }
        return countOne - ret;
    }
}
