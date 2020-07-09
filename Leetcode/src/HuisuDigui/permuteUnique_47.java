package HuisuDigui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * ****/
public class permuteUnique_47 {

    public static void main(String[] args) {
        permuteUnique_47 kobe = new permuteUnique_47();
        List<List<Integer>> lists = kobe.permuteUnique(new int[]{1,1,2});
        for (List<Integer> A:lists){
            System.out.println(A);
        }
    }


    List<List<Integer>> lists = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        //排序有助于去重
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        //回溯时的标记数组
        boolean[] visited = new boolean[nums.length];
        bfs(nums,list,visited);
        return lists;
    }

    private void bfs(int[] nums, List<Integer> list, boolean[] visited){
        if (list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!visited[i]){
                if (i>0 && !visited[i-1] && nums[i]==nums[i-1]){
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                bfs(nums,list,visited);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
