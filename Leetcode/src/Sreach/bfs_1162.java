package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * ***/
public class bfs_1162 {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxDistance(array));
    }

    //逆向思维,使用广度优先遍历,先把陆地加入队列,然后上下左右暴搜,最后面出队列的数组就是目标节点的坐标
    public static int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        if (m==0){
            return -1;
        }
        int n = grid[0].length;
        //将陆地节点加入队列
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        //如果全是海洋就直接返回
        if (queue.isEmpty() || queue.size()==m*n){
            return -1;
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int[] xy = null;
        while (!queue.isEmpty()){
            xy = queue.poll();
            for (int i=0;i<4;i++){
                int newDx = xy[0] + dx[i];
                int newDy = xy[1] + dy[i];
                if (newDx>=0 && newDx<m && newDy>=0 && newDy<n && grid[newDx][newDy]==0){
                    queue.add(new int[]{newDx,newDy});
                    //添加曼哈顿距离,作为数组值
                    grid[newDx][newDy] = grid[xy[0]][xy[1]] + 1;
                }
            }
        }
        if (xy==null){
            return -1;
        }
        return grid[xy[0]][xy[1]]-1;
    }
}
