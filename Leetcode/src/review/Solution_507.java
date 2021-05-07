package review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_507 {

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 示例：
     * <p>
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            StringBuilder temp = new StringBuilder(array[i]);
            res.append(temp.reverse());
            res.append(" ");
        }
        res.append(new StringBuffer(array[array.length - 1]).reverse());
        return res.toString();
    }


    /**
     * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
     * 你可以从你选择的任何树开始，然后重复执行以下步骤：
     * <p>
     * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
     * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
     * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，
     * 然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
     * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
     * 用这个程序你能收集的水果树的最大总量是多少？
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,1]
     * 输出：3
     * 解释：我们可以收集 [1,2,1]。
     * 示例 2：
     * <p>
     * 输入：[0,1,2,2]
     * 输出：3
     * 解释：我们可以收集 [1,2,2]
     * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
     */
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0){
            return 0;
        }
        int max = 0;
        // 滑动窗口
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            // 滑动
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
