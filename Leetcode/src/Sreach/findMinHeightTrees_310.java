package Sreach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *  
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 示例 2：
 * <p>
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 */
public class findMinHeightTrees_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        // 建图
        List<Integer>[] graphic = new List[n];
        // 建出度表
        int[] degree = new int[n];
        //创建队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graphic[edge[0]].add(edge[1]);
            graphic[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;

        }
        // 将入度为1的点加入队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        // 广度优先搜索,以最小出度的节点开始
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                ret.add(temp);
                for (int num : graphic[temp]) {
                    degree[num]--;
                    if (degree[num] == 1) {
                        queue.offer(num);
                    }
                }
            }
        }
        return ret;
    }
}
