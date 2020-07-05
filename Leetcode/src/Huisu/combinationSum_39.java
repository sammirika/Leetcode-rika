package Huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * ****/

//回溯复习2
public class combinationSum_39 {


    public static void main(String[] args) {
        combinationSum_39 kobe = new combinationSum_39();
        int[] A = new int[]{2,3,6,7};
        List<List<Integer>> lists = kobe.combinationSum(A,7);
        for (List<Integer> list:lists){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //拷贝一份，不影响下次递归
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }
}
