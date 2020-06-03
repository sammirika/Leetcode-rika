package day;

/**
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

        示例:

        输入:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        输出:
 **/

public class MaximalSquare {


    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int area = MaximalSquare.maximalSquare(matrix);
        System.out.println(area);
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0){
            return 0;
        }
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i][j]=='1'){
                    dp[i-1][j-1] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
