package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 */
public class setZeroes_73 {

    private static int m;

    private static int n;

    public static void setZeroes(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            dfs(matrix, temp[0], temp[1]);
        }
    }

    private static void dfs(int[][] matrix, int i, int j) {
        for (int a = 0; a < m; a++) {
            matrix[a][j] = 0;
        }
        for (int a = 0; a < n; a++) {
            matrix[i][a] = 0;
        }
    }
}
