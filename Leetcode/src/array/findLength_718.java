package array;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * ***/

public class findLength_718 {


    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}
