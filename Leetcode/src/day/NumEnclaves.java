package day;

/**
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 * 示例 1：
 *
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 *
 * 从边上的1点开始搜
 * */

public class NumEnclaves {
    int m;
    int n;

    public static void main(String[] args) {
        NumEnclaves kobe = new NumEnclaves();
        int[][] array = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int res = kobe.numEnclaves(array);
        System.out.println(res);
    }

    public  int numEnclaves(int[][] A) {
        this.m = A.length-1;
        this.n = A[0].length-1;
        int count = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(A[i][j]==1 &&(i==0||j==0||i==m||j==n)){
                    dfs(A,i,j);
                }
            }
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(A[i][j]==1){
                    count++;
                }
            }
        }
        return count;

    }
    private void dfs(int[][] A,int i,int j){
        if(i<0 || i>m || j<0 || j>n || A[i][j]==0){
            return;
        }
        A[i][j] = 0;
        dfs(A,i-1,j);
        dfs(A,i+1,j);
        dfs(A,i,j-1);
        dfs(A,i,j+1);
    }
}
