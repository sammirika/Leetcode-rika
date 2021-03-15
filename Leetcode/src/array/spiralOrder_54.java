package array;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 **/
public class spiralOrder_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
