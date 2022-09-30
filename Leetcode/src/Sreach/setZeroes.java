package Sreach;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class setZeroes {

    // 深度优先搜索
    int m;
    int n;

    public void setZeroes(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for (int[] pos:list){
            changeZero(pos[0],pos[1],matrix);
        }
    }

    private void changeZero(int x, int y, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            matrix[i][y] = 0;
        }
        for (int j = 0; j < n; j++) {
            matrix[x][j] = 0;
        }
    }
}
