package Hash;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 */
public class findDiagonalOrder_498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) {
            return new int[]{};
        }
        int row = mat.length;
        int col = mat[0].length;
        // 定义横纵坐标
        int r = 0;
        int c = 0;
        int[] ret = new int[row * col];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = mat[r][c];
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    // 常规向上
                    c++;
                    r--;
                }
            } else {
                // 不为偶数
                if (r == row - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    // 常规向下
                    r++;
                    c--;
                }
            }
        }
        return ret;
    }
}
