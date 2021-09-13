package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 */
public class numberOfBoomerangs_447 {

    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            // 暴力
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int m = entry.getValue();
                ret += m * (m - 1);
            }
        }
        return ret;
    }
}
