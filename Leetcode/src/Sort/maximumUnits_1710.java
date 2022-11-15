package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * 返回卡车可以装载 单元 的 最大 总数。
 * 示例 1：
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 * <p>
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 */
public class maximumUnits_1710 {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // 排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 比较数组第二位大小
                return o2[1] - o1[1];
            }
        });
        for (int[] box : boxTypes) {
            queue.add(box);
        }
        int max = 0;
        while (truckSize > 0 && !queue.isEmpty()) {
            if (queue.peek()[0] <= truckSize) {
                int[] box = queue.poll();
                max += box[0] * box[1];
                truckSize -= box[0];
            } else {
                int[] box = queue.poll();
                while (truckSize > 0) {
                    max += box[1];
                    truckSize--;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
