package Sreach;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：
 *
 * 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
 * 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
 * 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
 * 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]
 * 注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
 *
 * 一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
 *
 * 你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
 *
 * 请你返回让网格图至少有一条有效路径的最小代价。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
 * 输出：3
 * 解释：你将从点 (0, 0) 出发。
 * 到达 (3, 3) 的路径为： (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) 花费代价 cost = 1 使方向向下 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) 花费代价 cost = 1 使方向向下 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) 花费代价 cost = 1 使方向向下 --> (3, 3)
 * 总花费为 cost = 3.
 *
 * ******/
public class minCost_1368 {

    public static void main(String[] args) {
        minCost_1368 kobe = new minCost_1368();
        int[][] nums = new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println(kobe.minCost(nums));
    }

    //双端队列的bfs,类似于优先队列，每次都加的是最大或者最小的权值
    public int minCost(int[][] grid) {
        int m = grid.length;
        if (m==0){
            return 0;
        }
        int n = grid[0].length;
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(0,0,0));
        //1,2,3,4代表不同位置，这里的dx的索引直接对应即可
        int[] dx = new int[]{0,0,0,1,-1};
        int[] dy = new int[]{0,1,-1,0,0};
        boolean[][] visit = new boolean[m][n];
        while (!deque.isEmpty()){
            Node node = deque.pollFirst();
            visit[node.x][node.y] = true;
            if (node.x==m-1 && node.y==n-1){
                return node.cost;
            }
            for (int i=1;i<=4;i++){
                int newDx = node.x + dx[i];
                int newDy = node.y + dy[i];
                if (newDx<0 || newDy<0 || newDx>=m || newDy>=n || visit[newDx][newDy]){
                    continue;
                }
                //方向一致不需要cost加1直接加到队列前端,这样就满足同方向的始终在队列前端
                if (grid[node.x][node.y]==i){
                    deque.addFirst(new Node(newDx,newDy,node.cost));
                }else {
                    deque.addLast(new Node(newDx,newDy,node.cost+1));
                }
            }
        }
        return -1;
    }

    class Node{
        private int x;
        private int y;
        private int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
