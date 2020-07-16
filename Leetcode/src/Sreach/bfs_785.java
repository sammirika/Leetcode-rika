package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * ******/
public class bfs_785 {

    //染色标记
    private static int uncolor = 0;
    private static int red = 1;
    private static int green = 2;

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }

    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;
        if (n==0) {
            return true;
        }
        int[] color = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<n;i++){
            //没染色进行bfs,全部染色成功则直接ok
            if (color[i] == uncolor){
                queue.add(i);
                color[i] = red;
                while (!queue.isEmpty()){
                    int tmp = queue.poll();
                    //要染的颜色与之前的颜色要相反
                    int nColor = color[tmp] == red ? green:red;
                    for (int num:graph[tmp]){
                        if (color[num] == uncolor){
                            //染色
                            color[num] = nColor;
                            queue.add(num);
                        }else if (color[num] != nColor ){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
