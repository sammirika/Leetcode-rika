package HuisuDigui;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * ****/
public class combine_77 {

    // 回溯
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

    private void dfs(int n, int k , int index){
        // 出口
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<=n;i++){
            list.add(i);
            dfs(n,k,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combine_77 kobe = new combine_77();
        List<List<Integer>> lists = kobe.combine(4,2);
        for (List<Integer> list : lists){
            System.out.println(list);
        }
    }


}
