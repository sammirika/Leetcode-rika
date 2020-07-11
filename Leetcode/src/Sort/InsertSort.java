package Sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,3,4,78,25};
        nums = insetSort(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }

    //简单插入排序复习
    private static int[] insetSort(int[] nums){
        int len = nums.length;
        for (int i=1;i<len;i++){
            for (int j=i;j>0;j--){
                if (nums[j]<nums[j-1]){
                    //交换两数的位置,每次都是相邻的比较
                    int temp = nums[j-1];
                    nums[j-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }
}
