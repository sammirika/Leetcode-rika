package HuisuDigui;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 * <p>
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 ***/
public class findItinerary_332 {


    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 0) {
            return res;
        }
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<String>());
            }
            // 优先队列中保存，保证字典序
            map.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    // 从起点开始从后往前加入list
    private void dfs(String str) {
        while (map.containsKey(str) && map.get(str).size() > 0) {
            String temp = map.get(str).poll();
            dfs(temp);
        }
        res.add(str);
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>() {{
            add(Arrays.asList(new String[]{"MUC", "LHR"}));
            add(Arrays.asList(new String[]{"JFK", "MUC"}));
            add(Arrays.asList(new String[]{"SFO", "SJC"}));
            add(Arrays.asList(new String[]{"LHR", "SFO"}));
        }};
        findItinerary_332 kobe = new findItinerary_332();
        List<String> list = kobe.findItinerary(lists);
        for (String temp : list) {
            System.out.println(temp);
        }
    }
}
