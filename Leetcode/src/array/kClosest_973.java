package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * ***/
public class kClosest_973 {

    public int[][] kClosest(int[][] points, int K) {
        // 利用优先队列解决
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int) Math.floor(getDis(o1[0], o1[1]) - getDis(o2[0], o2[1]));
            }
        });
        for (int[] point : points) {
            priorityQueue.add(point);
        }
        List<int[]> res = new ArrayList<>();
        while (K > 0 && !priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
            K--;
        }
        return res.toArray(new int[0][]);
    }

    private double getDis(int x, int y) {
        return Math.sqrt((x-0) * (x-0) + (y-0) * (y-0))*10;
    }
}
