/**
 *
 * 给你一个 R 行 C 列的整数矩阵 A。矩阵上的路径从 [0,0] 开始，在 [R-1,C-1] 结束。
 *
 * 路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。
 *
 * 路径的得分是该路径上的 最小 值。例如，路径 8 →  4 →  5 →  9 的值为 4 。
 *
 * 找出所有路径中得分 最高 的那条路径，返回其 得分。
 *
 *输入：[[5,4,5],[1,2,6],[7,4,6]]  || [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * [[2,0,2,3,1],[0,2,2,3,3],[2,3,0,2,3],[1,1,2,3,1],[2,2,0,0,1]]
 * 输出：4 || 3
 * 解释：
 * 得分最高的路径用黄色突出显示。
 * ****/
//可以dfs一次直接搜完，上下左右只搜最大值

package Sreach;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumMinimumPath {
    int m;
    int n;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] A = new int[][]{{2,0,2,3,1},{0,2,2,3,3},{2,3,0,2,3},{1,1,2,3,1},{2,2,0,0,1}};
        MaximumMinimumPath kobe = new MaximumMinimumPath();
        System.out.println(kobe.maximumMinimumPath1(A));
    }


    //错误解法会超时
    public int maximumMinimumPath(int[][] A) {
        this.m = A.length;
        if (m==0){
            return 0;
        }
        this.n = A[0].length;
        int[][] visit = new int[m][n];
        dfs(0,0,A,visit);
        int min = list.get(0);
        for(int i=1;i<list.size();i++){
            min = Math.min(min,list.get(i));
        }
        return min;
    }
    private void dfs(int i, int j, int[][] A ,int[][] visit){
        list.add(A[i][j]);
        visit[i][j] = 1;
        if((i==m-1 && j==n-1) || A[i][j]==0){
            return;
        }
        int top=0,down=0,left=0,right = 0;
        if(i>0 && visit[i-1][j] == 0){
            top = A[i-1][j];
        }
        if(i<m-1 && visit[i+1][j] == 0){
            down = A[i+1][j];
        }
        if(j>0 && visit[i][j-1] == 0 ){
            left = A[i][j-1];
        }
        if(j<n-1 && visit[i][j+1] == 0){
            right = A[i][j+1];
        }
        if(i>0 && top>=left && top>=right && top>=down){
            dfs(i-1,j,A,visit);
        }else if (i<m-1 && down>=top && down>=left && down>=right){
            dfs(i+1,j,A,visit);
        }else if(j>0 && left>=right && left>=top && left>down){
            dfs(i,j-1,A,visit);
        }else if(j<n-1 && right>left && right>=top && right>=down){
            dfs(i,j+1,A,visit);
        }
    }

    //正确解法
    class Node{
        int col;
        int row;
        int val;
    }
    public int maximumMinimumPath1(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<Node> heap = new PriorityQueue<Node>((Node o1, Node o2)->(o2.val-o1.val));
        boolean[][] mark = new boolean[m][n];
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        // 最短路径,每次取
        Node n0 = new Node();
        n0.col = 0;n0.row = 0;n0.val = A[0][0];
        heap.add(n0);
        mark[0][0] = true;
        int res = A[0][0];
        while(!heap.isEmpty()){
            Node cur = heap.poll();
            // System.out.println(cur.val);
            res = Math.min(cur.val,res);
            if(cur.col==n-1&&cur.row==m-1){return res;}
            for(int k=0;k<4;k++){
                int nx = cur.row+direction[k][0];
                int ny = cur.col+direction[k][1];
                if(nx>=0&&ny>=0&&nx<m&&ny<n&&!mark[nx][ny]){
                    Node n1 = new Node();
                    n1.row = nx;
                    n1.col = ny;
                    n1.val = A[nx][ny];
                    heap.add(n1);
                    mark[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
