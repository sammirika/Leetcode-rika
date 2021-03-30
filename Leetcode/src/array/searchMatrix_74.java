package array;


/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 */
public class searchMatrix_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 二分搜索
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n - 1;
            if (matrix[i][r] < target) {
                continue;
            }
            while (l <= r) {
                int mid = (l + r) / 2;
                if (matrix[i][mid] > target) {
                    r = mid-1;
                } else if (matrix[i][mid] < target) {
                    l = mid+1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
