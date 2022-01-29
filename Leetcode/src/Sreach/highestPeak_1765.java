package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，
 * 就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。
 * 如果有多种解法，请返回 任意一个 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 */
public class highestPeak_1765 {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] Visit = new boolean[m][n];
        int[][] height = new int[m][n];
        //  给height赋初值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    Visit[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 广搜
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !Visit[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    height[newX][newY] = height[x][y] + 1;
                    Visit[newX][newY] = true;
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] isWater = new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        highestPeak_1765 kobe = new highestPeak_1765();
        int[][] ret = kobe.highestPeak(isWater);
        for (int[] tmp : ret) {
            for (int val : tmp) {
                System.out.print(val + " ");
            }
            System.out.println(" ");
        }
    }
}
