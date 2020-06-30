package Sort;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * ****/
//基本数据类型使用快排
public class findKthLargest_215 {

    public static void main(String[] args) {
        findKthLargest_215 kobe = new findKthLargest_215();
        int[] array = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(kobe.findKthLargest(array,4));
    }

    public int findKthLargest(int[] nums, int k) {
        //快排
        quickSort(0,nums.length-1,nums);
        int len = nums.length;
        return nums[len-k];
    }

    private void quickSort(int left,int right,int[] nums){
        if(left>right){
            return;
        }
        int l = left;
        int r = right;
        int key = nums[left];
        while(l<r){
            while(l<r && nums[r]>=key){
                r--;
            }
            nums[l] = nums[r];
            while(l<r && nums[l]<=key){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        //左右分治
        quickSort(left,l-1,nums);
        quickSort(r+1,right,nums);
    }
}
