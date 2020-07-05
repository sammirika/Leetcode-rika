package Huisu;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * *****/
public class permute_46 {

    List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        permute_46 kobe = new permute_46();
        int[] A = new int[]{1,2,3};
        List<List<Integer>> list = kobe.permute(A);
        for (List<Integer> list1:list){
            System.out.println(list1);
        }
    }
    //回溯复习
    public List<List<Integer>> permute(int[] nums) {
        int[] visit = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        backBuild(nums,list,visit);
        return lists;
    }

    private void backBuild(int[] nums, List<Integer> list, int[] visit){
        //递归出口
        if (list.size()==nums.length){
            //牢记容器的添加方式
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            //被访问过就直接continue
            if (visit[i] == 1){
                continue;
            }
            visit[i] = 1;
            list.add(nums[i]);
            backBuild(nums,list,visit);
            //每次递归之后再重新归零
            visit[i] = 0;
            //剪枝
            list.remove(list.size()-1);
        }
    }

}
