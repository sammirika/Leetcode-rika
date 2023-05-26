package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，
 * 该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。 
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 */
public class shortestPathBinaryMatrix_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return -1;
        }
        int n = m;
        if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 8个方向
        int[] dx = new int[]{0, 0, 1, -1, -1, 1, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
        grid[0][0] = 1;
        boolean[][] visit = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            if (xy[0] == m - 1 && xy[1] == n - 1) {
                return grid[xy[0]][xy[1]];
            }
            for (int i = 0; i < 8; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx < 0 || newDy < 0 || newDx >= m || newDy >= n || visit[newDx][newDy] || grid[newDx][newDy] != 0) {
                    continue;
                }
                visit[newDx][newDy] = true;
                grid[newDx][newDy] = grid[xy[0]][xy[1]] + 1;
                queue.offer(new int[]{newDx, newDy});
            }
        }
        return -1;
    }
}
