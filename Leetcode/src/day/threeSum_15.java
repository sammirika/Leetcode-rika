package day;
import java.util.*;

/**
 *
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。

 示例：
 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 *
 * ******/
public class threeSum_15 {

    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> A:list){
            System.out.println(A);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        //将数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int sum = 0 - nums[i];
            //每次的循环
            while (l<r) {
                if (nums[l] + nums[r] == sum) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重操作，排了序之后可能存在重复的情况
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<List<Integer>>(lists);
    }
}
