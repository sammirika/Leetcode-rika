package Sreach;

import java.util.*;

public class bfs_210 {
    public static void main(String[] args) {
        int[] array = findOrder(4,new int[][]{{0,2},{1,2},{2,1},{2,3}});
        for (int a:array){
            System.out.println(a);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        //简单拓扑排序，因为课程之间存在因果关系，所以存在拓扑关系
        //1.构造图之间的关系,一共numCourses个课程,下标代表的永远是点
        List<Integer>[] graphic = new List[numCourses];
        for (int i=0;i<numCourses;i++){
            //每一对图之间关系用ArrayList表示
            graphic[i] = new ArrayList<>();
        }
        for (int[] A:prerequisites){
            graphic[A[0]].add(A[1]);
        }
        //构造入度表
        int[] ingreed = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            for (int num:graphic[i]){
                ingreed[num]++;
            }
        }
        //找到入度为0的起点进入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (ingreed[i]==0){
                queue.add(i);
            }
        }
        //拓扑排序构造数组
        while (!queue.isEmpty()){
            int temp = queue.poll();
            list.add(temp);
            numCourses--;
            for(int B:graphic[temp]) {
                ingreed[B]--;
                if (ingreed[B]==0){
                    queue.add(B);
                }
            }
        }
        if (numCourses!=0){
            return new int[]{};
        }
        Collections.reverse(list);
        int[] aim = new int[list.size()];
        for (int i=0;i<aim.length;i++){
            aim[i] = list.get(i);
        }
        return aim;
    }
}
