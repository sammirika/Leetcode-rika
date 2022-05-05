package Sreach;

import java.util.*;

/**
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 */
public class pacificAtlantic_417 {

    public static List<List<Integer>> pacificAtlantic(int[][] height) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        //第一遍广搜先将太平洋搞定
        int m = height.length;
        if (m == 0) {
            return lists;
        }
        int n = height[0].length;
        int[][] visit = new int[m][n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i});
            visit[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            queue.add(new int[]{i, 0});
            visit[i][0] = 1;
        }
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n
                        && visit[newDx][newDy] == 0 && height[newDx][newDy] >= height[xy[0]][xy[1]]) {
                    visit[newDx][newDy]++;
                    queue.add(new int[]{newDx, newDy});
                }
            }
        }
        //第二次广搜
        boolean[][] judge = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (visit[i][n - 1] == 1) {
                visit[i][n - 1]++;
            }
            queue.add(new int[]{i, n - 1});
            judge[i][n - 1] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (visit[m - 1][i] == 1) {
                visit[m - 1][i]++;
            }
            queue.add(new int[]{m - 1, i});
            judge[m - 1][i] = true;
        }
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n
                        && height[newDx][newDy] >= height[xy[0]][xy[1]] && !judge[newDx][newDy]) {
                    if (visit[newDx][newDy] == 1) {
                        visit[newDx][newDy]++;
                    }
                    judge[newDx][newDy] = true;
                    queue.add(new int[]{newDx, newDy});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> lists = pacificAtlantic(matrix);
        for (List<Integer> A : lists) {
            System.out.println(A);
        }
    }
}
