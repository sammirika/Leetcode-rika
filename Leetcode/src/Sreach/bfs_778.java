package Sreach;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 示例 1:

 输入: [[0,2],[1,3]]
 输出: 3
 解释:
 时间为0时，你位于坐标方格的位置为 (0, 0)。
 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。

 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 示例2:

 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 输出: 16
 解释:
 0  1  2  3  4
 24 23 22 21  5
 12 13 14 15 16
 11 17 18 19 20
 10  9  8  7  6

 最终的路线用加粗进行了标记。
 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 * *****/

public class bfs_778 {

    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
    }

    //每一次移动都是瞬移，所以满足移动条件的最小的周围的点就是移动的目标，同时，路径中最大的点就是要取得值；这里考虑使用优先队列，每次取最小值,找到(m-1,n-1)的店就结束了
    public static int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //保证升序的优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        queue.add(new int[]{0,0,grid[0][0]});
        //上下左右
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        while (!queue.isEmpty()){
            //每次出队列的都是最小值
            int[] xy = queue.poll();
            int num = xy[2];
            //搜索到右下角最底点，搜索结束
            if(xy[0]==m-1 && xy[1]==n-1){
                return num;
            }
            //上下左右依次遍历
            for (int i=0;i<4;i++){
                int newdx = dx[i] + xy[0];
                int newdy = dy[i] + xy[1];
                //如果越界或者已经访问过，就可以不用加入队列中
                if(newdx<0 || newdy<0 || newdx>m-1 || newdy>n-1 || visit[newdx][newdy]){
                    continue;
                }
                //覆盖新点的值每次为最小值
                visit[newdx][newdy] = true;
                int max = Math.max(num,grid[newdx][newdy]);
                queue.add(new int[]{newdx,newdy,max});
            }
        }
        return 0;
    }
}
