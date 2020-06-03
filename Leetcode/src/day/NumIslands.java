package day;

/***
 *
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。



 示例 1:

 输入:
 11110
 11010
 11000
 00000
 输出: 1
 *
 * **/


public class NumIslands {

    int m;
    int n;

    public static void main(String[] args) {
        char[][] A = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
        NumIslands kobe = new NumIslands();
        int num = kobe.numIslands(A);
        System.out.println(num);
    }

    public int numIslands(char[][] grid) {
        this.m = grid.length-1;
        this.n = grid[0].length-1;
        int count = 0;
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if(i>0 && grid[i-1][j]=='1'){
            dfs(grid,i-1,j);
        }
        if(i<m && grid[i+1][j]=='1'){
            dfs(grid,i+1,j);
        }
        if(j>0 && grid[i][j-1]=='1'){
            dfs(grid,i,j-1);
        }
        if(j<n && grid[i][j+1]=='1'){
            dfs(grid,i,j+1);
        }
    }
}
