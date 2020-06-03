package Sreach;

import java.util.*;

/***
 *
 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 示例 1:
 输入: 2, [[1,0]]
 输出: true
 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 示例 2:
 输入: 2, [[1,0],[0,1]]
 输出: false
 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * **/
public class bfs_207 {
    public static void main(String[] args) {
        System.out.println(canFinish(4,new int[][]{{0,2},{1,2},{2,3}}));
    }

    // 判断图是否有环，利用图节点的出度来计算
    // 构造邻接表来存储图，List<Integer>[] graphic = new List[numCourses];
    // 利用入度矩阵存储每个节点的入度
    // 将入度为0的节点一次入队，然后遍历，减少其对应端点的入度
    // 最后判断是否全部入队
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.根据边的关系来构造图,每一个list对象保存点与点之间的连接关系
        List<Integer>[] graphic = new List[numCourses];
        //队列中存放入度为0的点
        Queue<Integer> queue = new LinkedList<>();
        //构建关系
        for (int i=0;i<numCourses;i++){
            graphic[i] = new ArrayList<>();
        }
        for(int[] array:prerequisites){
            graphic[array[0]].add(array[1]);
        }
        //2.出度表构建
        int[] indegreed = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for (int num:graphic[i]){
                indegreed[num]++;
            }
        }
        //一次性加入所有入度为0的节点
        for(int i=0;i<numCourses;i++){
            if (indegreed[i]==0){
                queue.add(i);
            }
        }
        //3.拓扑排序求解,bfs广度优先搜索
        while (!queue.isEmpty()){
            int temp = queue.poll();
            numCourses--;
            for (int num:graphic[temp]){
                indegreed[num]--;
                if (indegreed[num]==0){
                    queue.add(num);
                }
            }
        }
        return numCourses==0;
    }
}
