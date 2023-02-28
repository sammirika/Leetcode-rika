package FormalStruct;

import java.util.*;

/**
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 * <p>
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 * <p>
 * 注意：ret 应该按价值 升序 排序后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * 输出：[[1,6],[3,9],[4,5]]
 * 解释：
 * value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 5 ，总重量为 1 + 5 = 6 。
 * value = 3 的物品再 items1 中 weight = 8 ，在 items2 中 weight = 1 ，总重量为 8 + 1 = 9 。
 * value = 4 的物品在 items1 中 weight = 5 ，总重量为 5 。
 * 所以，我们返回 [[1,6],[3,9],[4,5]] 。
 */
public class mergeSimilarItems_2363 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            if (!map.containsKey(items1[i][0])) {
                map.put(items1[i][0], items1[i][1]);
            } else {
                map.put(items1[i][0], map.get(items1[i][0]) + items1[i][1]);
            }
        }
        for (int i = 0; i < items2.length; i++) {
            if (!map.containsKey(items2[i][0])) {
                map.put(items2[i][0], items2[i][1]);
            } else {
                map.put(items2[i][0], map.get(items2[i][0]) + items2[i][1]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ret.add(list);
        }
        return ret;
    }
}
