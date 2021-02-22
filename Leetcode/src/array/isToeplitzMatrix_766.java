package array;


import java.util.LinkedList;
import java.util.Queue;

/***
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * **/
public class isToeplitzMatrix_766 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 广搜简单解法
        Queue<int[]> queue = new LinkedList<>();
        // 第一列加入队列
        for (int i = m - 1; i >= 0; i--) {
            queue.add(new int[] {i, 0});
        }
        // 第一行加入队列
        for (int i = 1; i < n; i++) {
            queue.add(new int[] {0, i});
        }
        while (!queue.isEmpty()) {
            // 取出每一个起始点坐标
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int temp = matrix[x][y];
            while (x < m && y < n) {
                x += 1;
                y += 1;
                if (x < m && y < n && matrix[x][y] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
