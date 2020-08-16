package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 ****/
public class floodFill_733 {

    private int m;
    private int n;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    //dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.m = image.length;
        if (m == 0) {
            return image;
        }
        this.n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(sr, sc, visited, image, image[sr][sc]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] image, int color) {
        //符合条件的都会变成true
        if (image[x][y] == color) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n
                        && !visited[newDx][newDy]) {
                    dfs(newDx, newDy, visited, image, color);
                }
            }
        }

    }

    //广搜 bfs 可能还比较简单
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        this.m = image.length;
        if (m == 0) {
            return image;
        }
        this.n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        //初始坐标进入队列
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            visited[xy[0]][xy[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx >= 0 && newDx < m && newDy >= 0 && newDy < n && !visited[newDx][newDy]
                        && image[newDx][newDy] == image[xy[0]][xy[1]]) {
                    queue.add(new int[]{newDx, newDy});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        floodFill_733 kobe = new floodFill_733();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] newImage = kobe.floodFill(image, 1, 1, 2);
        for (int[] nums : newImage) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println(" ");
        }
    }
}
