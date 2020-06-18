package Dp;
/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * ****/
public class minPathSum_64 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    //每次比较上或者左边的最小值，依次更新DP数组就可以了
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m==0){
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=0,j=1;j<n;j++){
            dp[i][j] = dp[i][j-1] + grid[i][j];
        }
        for (int i=1,j=0;i<m;i++){
            dp[i][j] = dp[i-1][j] + grid[i][j];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i][j-1] + grid[i][j],dp[i-1][j] + grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
