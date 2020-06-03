/**
 *
 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

 两个相邻元素间的距离为 1 。
 给定矩阵的元素个数不超过 10000。
 给定矩阵中至少有一个元素是 0。
 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 输入:
 0 0 0
 0 1 0
 1 1 1
 输出:
 0 0 0
 0 1 0
 1 2 1
 *
 * ***/

package Sreach;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    queue.add(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            int[] array = queue.poll();
            for (int i=0;i<4;i++){
                int Newdx = dx[i] + array[0];
                int Newdy = dy[i] + array[1];
                if (Newdx>=0 && Newdy>=0 && Newdx<=m-1 && Newdy<=n-1 && matrix[Newdx][Newdy]==-1){
                    matrix[Newdx][Newdy] = matrix[array[0]][array[1]] + 1;
                    queue.offer(new int[]{Newdx,Newdy});
                }
            }
        }
        return matrix;
    }
}
