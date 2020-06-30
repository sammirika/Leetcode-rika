package Sreach;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * ******/

public class bfs_130 {

    public static void main(String[] args) {
        char[][] array = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(array);
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        if (m==0){
            return;
        }
        int n= board[0].length;
        //将边界上的'O'变化
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if ((i==0||j==0||i==m-1||j==n-1) && board[i][j]=='O'){
                    board[i][j] = '-';
                    //并加入队列
                    queue.add(new int[]{i,j});
                }
            }
        }
        boolean[][] visit = new boolean[m][n];
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            //表示访问过
            visit[xy[0]][xy[1]] = true;
            for (int i=0;i<4;i++){
                int newdx = xy[0] + dx[i];
                int newdy = xy[1] + dy[i];
                if (newdx>0 && newdx<m && newdy>0 && newdy<n && board[newdx][newdy]=='O' && !visit[newdx][newdy]){
                    //边界附近的‘O’只要上下左右出现‘O’都给它变成'-'
                    board[newdx][newdy] = '-';
                    visit[newdx][newdy] = true;
                    queue.add(new int[]{newdx,newdy});
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]=='-'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
