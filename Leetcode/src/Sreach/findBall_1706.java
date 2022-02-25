package Sreach;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。
 * 如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，
 * 如果球卡在盒子里，则返回 -1 。
 * 示例 1：
 *
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 */
public class findBall_1706 {

    private int[] dx = new int[] {-1, 1, 0, 0};

    private int[] dy = new int[] {0, 0, -1, 1};

    public int[] findBall(int[][] grid) {
        Deque<Node> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            queue.add(new Node(0, i, i));
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (x == m) {
                res[node.index] = y;
            }
            if (x >= 0 && y >= 0 && x < m && y < n) {
                if (grid[x][y] == 1 && y != n - 1 && grid[x][y + 1] == 1) {
                    queue.addFirst(new Node(x + 1, y + 1, node.index));
                } else if (grid[x][y] == -1 && y != 0 && grid[x][y - 1] == -1) {
                    queue.addFirst(new Node(x + 1, y - 1, node.index));
                }
            }
        }
        return res;
    }

    class Node {
        private int x;

        private int y;

        private int index;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}
