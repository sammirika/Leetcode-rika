package Sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
 * <p>
 * 请你返回排序后的数组。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 */
public class frequencySort_1636 {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // 记录频率
        for (int num : nums) {
            frequencyMap.putIfAbsent(num, 1);
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!frequencyMap.get(o1).equals(frequencyMap.get(o2))) {
                    return frequencyMap.get(o1) - frequencyMap.get(o2);
                } else {
                    return o2 - o1;
                }
            }
        });
        // 进入优先队列
        for (int num : nums) {
            queue.add(num);
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = queue.poll();
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,-6,4,5,-6,1,4,1};
        int[] ret = frequencySort(nums);
        for (int num : ret) {
            System.out.print(num + " ");
        }
    }
}

