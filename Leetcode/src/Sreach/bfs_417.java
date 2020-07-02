package Sreach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 *
 * ******/
public class bfs_417 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = pacificAtlantic(matrix);
        for (List<Integer> A:lists){
            System.out.println(A);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        //第一遍广搜先将太平洋搞定
        int m = matrix.length;
        if (m==0){
            return lists;
        }
        int n = matrix[0].length;
        int[][] visit = new int[m][n];
        for (int i=0;i<n;i++){
            queue.add(new int[]{0,i});
            visit[0][i] = 1;
        }
        for (int i=1;i<m;i++){
            queue.add(new int[]{i,0});
            visit[i][0] = 1;
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        //第一次广搜,将所有能流入太平洋的点变为1
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            for (int i=0;i<4;i++){
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx>=0 && newDx<m && newDy>=0 && newDy<n
                        && visit[newDx][newDy]==0 && matrix[newDx][newDy]>=matrix[xy[0]][xy[1]]){
                    queue.add(new int[]{newDx,newDy});
                    visit[newDx][newDy] = 1;
                }
            }

        }
        //第二次广搜
        boolean[][] judge = new boolean[m][n];
        for (int i=0;i<m;i++){
            if (visit[i][n-1]==1){
                visit[i][n-1]++;
            }
            queue.add(new int[]{i,n-1});
            judge[i][n-1] = true;
        }

        for (int i=0;i<n-1;i++){
            if (visit[m-1][i]==1){
                visit[m-1][i]++;
            }
            queue.add(new int[]{m-1,i});
            judge[m-1][i] = true;
        }
        //第二次广搜
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            for (int i=0;i<4;i++){
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx>=0 && newDx<m && newDy>=0 && newDy<n
                        &&  matrix[newDx][newDy]>=matrix[xy[0]][xy[1]]
                        && !judge[newDx][newDy]){
                    if (visit[newDx][newDy]==1){
                        visit[newDx][newDy]++;
                    }
                    judge[newDx][newDy] = true;
                    queue.add(new int[]{newDx,newDy});
                }
            }

        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (visit[i][j]==2){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
