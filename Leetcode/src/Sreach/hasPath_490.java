package Sreach;


import java.util.LinkedList;
import java.util.Queue;

/***
 * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
 * 给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。
 * 起始位置和目的地的坐标通过行号和列号给出。
 * 示例 1:
 *
 * 输入 1: 迷宫由以下二维数组表示
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
 * 输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
 *
 * 输出: true
 *
 * ***/

// 遇到墙壁才可以，需要增加判断
public class hasPath_490 {

    private int m;
    private int n;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        if (m == 0) {
            return false;
        }
        this.n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visit[start[0]][start[1]] = true;
        queue.add(new int[]{start[0], start[1]});
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            visit[x][y] = true;
            // 终止条件
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                // 重点是需要一直往下搜索，直到遇到墙壁，如果遇到墙壁这些点满足才为true
                while (newDx >= 0 && newDy >= 0 && newDx < m && newDy < n && maze[newDx][newDy] == 0) {
                    newDx += dx[i];
                    newDy += dy[i];
                }
                // 回退一个点
                newDx -= dx[i];
                newDy -= dy[i];
                if (!visit[newDx][newDy]) {
                    queue.add(new int[]{newDx, newDy});
                }
            }
        }
        return false;
    }


}
