package Brainteasers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 字符串保证唯一
 */
public class findRestaurant_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != " ") {
                map.put(list1[i], i);
            }
        }
        int min = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (!map.containsKey(list2[i])) {
                continue;
            }
            if (map.get(s) + i < min) {
                ret.clear();
                min = map.get(s) + i;
                ret.add(list2[i]);
            } else if ((map.get(s) + i) == min) {
                ret.add(list2[i]);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
