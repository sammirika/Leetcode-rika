package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */
public class equalPairs_2352 {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> mapRow = new HashMap<>();
        Map<String, Integer> mapCol = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb1.append('0' + grid[i][j]);
                sb2.append('0' + grid[j][i]);
            }
            mapRow.put(sb1.toString(), mapRow.getOrDefault(sb1.toString(), 0) + 1);
            mapCol.put(sb2.toString(), mapCol.getOrDefault(sb2.toString(), 0) + 1);
            if (mapCol.containsKey(sb1.toString())) {
                ret += mapCol.get(sb1.toString());
            }
            if (mapRow.containsKey(sb2.toString())) {
                ret += mapRow.get(sb2.toString());
            }
            if (sb1.toString().equals(sb2.toString())) {
                ret--;
            }
        }
        return ret;
    }
}
