package Sreach;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * */
public class minCostConnectPoints_1584 {


    // 真实的最小生成树
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[] dis = new int[len];
        int[][] graph = new int[len][len];
        boolean[] visit = new boolean[len];
        // 新建邻接矩阵
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);
                graph[j][i] = graph[i][j];
            }
        }
        // 从起点开始构建最小生成树
        visit[0] = true;
        for (int j = 1; j < len; j++) {
            dis[j] = graph[j][0];
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            int minIndex = -1;
            // 找最短边
            for (int j = 1; j < len; j++) {
                if (!visit[j] && (minIndex == -1 || dis[minIndex] > dis[j])) {
                    minIndex = j;
                }
            }
            visit[minIndex] = true;
            res += dis[minIndex];
            // 重新构建dis数组
            for (int j = 1; j < len; j++) {
                if (!visit[j]) {
                    dis[j] = Math.min(dis[j], graph[minIndex][j]);
                }
            }
        }
        return res;
    }
}
