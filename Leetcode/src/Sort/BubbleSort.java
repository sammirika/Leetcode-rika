package Sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,3,4,78,25};
        nums = bubblesort(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }


    private static int[] bubblesort(int[] nums){
        //冒泡排序复习
        for (int i=0;i<nums.length;i++){
            //每次都会把最大的数放到最后一个
            for (int j=0;j<nums.length-1-i;j++){
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }

            }
        }
        return nums;
    }
}
