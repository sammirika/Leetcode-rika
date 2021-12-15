package Sreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。
 * 为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。
 * 另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰
 * （也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，
 * 在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 * 示例 1：
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 */
public class loudAndRich_851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // 建图
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] rich : richer) {
            // 保存比自己更富有的
            graph[rich[1]].add(rich[0]);
        }
        // 新建ans数组记录
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        //深搜遍历图
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, graph, ans);
        }
        return ans;
    }

    private void dfs(int x, int quiet[], List<Integer>[] graph, int[] ans) {
        // 找到直接返回避免重复计算
        if (ans[x] != -1){
            return;
        }
        // 最简单的情况自己就是最安静的
        ans[x] = x;
        for (Integer y:graph[x]){
            dfs(y,quiet,graph,ans);
            if (quiet[ans[y]] < quiet[ans[x]]){
                ans[x] = ans[y];
            }
        }
    }
}
