package array;
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * ***/
public class searchInsert_35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]){
            return 0;
        }
        int index = 0;
        while (index < nums.length-1){
            if (nums[index] == target){
                return index;
            }
            if (nums[index] < target && nums[index+1] >= target){
                return index+1;
            }
            index++;
        }
        return index+1;
    }
}
