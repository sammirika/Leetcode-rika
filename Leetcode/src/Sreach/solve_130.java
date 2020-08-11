package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * *****/
public class solve_130 {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int m;
    private int n;

    //bfs,扫的时候先边四边'O'加入队列,然后依次扩展,时间复杂度固定的就是遍历完board的复杂度
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = '#';
                    queue.add(new int[]{i, j});
                }
            }
        }
        //广度优先搜索,符合条件的'O'变成'#'
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || board[newDx][newDy] != 'O') {
                    continue;
                }
                board[newDx][newDy] = '#';
                queue.add(new int[]{newDx, newDy});
            }
        }
        //还原
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }



    //dfs,深度优先搜索
    public void solve1(char[][] board) {
        this.m = board.length;
        if (m == 0) {
            return;
        }
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        //还原
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '#';
        for (int x = 0; x < 4; x++) {
            int newDx = dx[x] + i;
            int newDy = dy[x] + j;
            if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n && board[newDx][newDy] == 'O') {
                board[newDx][newDy] = '#';
                dfs(board, newDx, newDy);
            }
        }
    }
}
