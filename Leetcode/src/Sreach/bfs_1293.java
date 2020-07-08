package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 * 示例 1：
 *
 * 输入：
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *
 * ***/
public class bfs_1293 {
    public static void main(String[] args) {
        bfs_1293 kobe = new bfs_1293();
        int[][] nums = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        System.out.println(kobe.shortestPath(nums,6));
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        if (m==0){
            return -1;
        }
        int n= grid[0].length;
        //三维矩阵记录状态
        boolean[][][] visit = new boolean[k+1][m][n];
        visit[k][0][0] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,k));
        int step = 0;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                Node node = queue.poll();
                if (node.row==m-1 && node.col==n-1){
                    return step-1;
                }
                for (int j=0;j<4;j++){
                    int newDx = node.row+dx[j];
                    int newDy = node.col+dy[j];
                    if (newDx>=0 && newDy>=0 && newDx<m && newDy<n){
                        if (grid[newDx][newDy]==1){
                            if (node.k>0 && !visit[node.k-1][newDx][newDy]){
                                queue.add(new Node(newDx,newDy,node.k-1));
                                visit[node.k-1][newDx][newDy] = true;
                            }
                        }else {
                            if (!visit[node.k][newDx][newDy]){
                                queue.add(new Node(newDx,newDy,node.k));
                                visit[node.k][newDx][newDy] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    class Node{
        private int row;
        private int col;
        private int k;
        //这里的k记录没各一个点的能消除障碍物的个数
        public Node(int row, int col ,int k){
            this.row = row;
            this.col = col;
            this.k = k;
        }
    }


}
