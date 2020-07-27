package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动
 *****/
public class longestIncreasingPath_329 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        longestIncreasingPath_329 kobe = new longestIncreasingPath_329();
        System.out.println(kobe.longestIncreasingPath1(grid));
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    int m;
    int n;



    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int i=0;i<4;i++){
            int newRow = row + dx[i], newColumn = column + dy[i];
            if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }


    //广搜超时
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        if (m == 0) {
            return 0;
        }
        this.n = matrix[0].length;
        //因为不是一开始就确定点的，这个序列有可能在矩阵中间，所以得遍历每一个点广搜,只需要求递增的序列即可
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, bfs(matrix, i, j));
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        //每一次都广搜一次
        int ox = x;
        int oy = y;
        //递增序列
        int maxValue = 0;
        Queue<int[]> queue = new LinkedList<>();
        //起点加入队列
        queue.add(new int[]{ox, oy});
        int[][] visit = new int[grid.length][grid[0].length];
        visit[ox][oy] = 1;
        //广搜
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            //每次更新递增值
            maxValue = Math.max(maxValue, visit[xy[0]][xy[1]]);
            for (int i = 0; i < 4; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx < 0 || newDy < 0 || newDx >= m || newDy >= n) {
                    continue;
                }
                if (grid[newDx][newDy] > grid[xy[0]][xy[1]]) {
                    queue.add(new int[]{newDx, newDy});
                    visit[newDx][newDy] = visit[xy[0]][xy[1]] + 1;
                }
            }
        }
        return maxValue;
    }

}
