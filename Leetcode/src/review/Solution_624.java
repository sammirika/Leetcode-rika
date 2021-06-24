package review;

public class Solution_624 {

    /**
     * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。
     * 求最多有多少个点在同一条直线上。
     * 示例 1：
     * <p>
     * <p>
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：3
     * 示例 2：
     * <p>
     * <p>
     * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出：4
     */
    public int maxPoints(int[][] points) {
        int len = points.length;
        int res = 1;
        for (int i = 0; i < len; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] y = points[j];
                int temp = 2;
                for (int k = j + 1; k < len; k++) {
                    int[] p = points[k];
                    int l1 = (p[0] - y[0]) * (y[1] - x[1]);
                    int l2 = (y[0] - x[0]) * (p[1] - y[1]);
                    if (l1 == l2) {
                        temp++;
                    }
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
