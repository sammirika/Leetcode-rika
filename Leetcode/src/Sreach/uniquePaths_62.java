package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * **/
public class uniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        queue.add(new int[] {0, 0});
        int[] dx = new int[] {1, 0};
        int[] dy = new int[] {0, 1};
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for (int i = 0; i < 2; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx >= 0 && newDy >= 0 && newDx < m && newDy < n) {
                    grid[newDx][newDy] += grid[x][y];
                    if (!visit[newDx][newDy]) {
                        queue.add(new int[] {newDx, newDy});
                        visit[newDx][newDy] = true;
                    }
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
