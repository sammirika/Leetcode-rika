/****
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * ***/

package Sort;

public class SortColors {
    public static void main(String[] args) {
        SortColors kobe = new SortColors();
        int[] array = new int[]{2,0,2,1,1,0};
        kobe.sortColors(array);
        for (int a:array){
            System.out.println(a);
        }
    }

    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int left,int right){
        if (left>right){
            return;
        }
        int l = left;
        int r = right;
        int key = nums[l];
        while (l<r){
            while (l<r && key<=nums[r]){
                r--;
            }
            nums[l] = nums[r];
            while (l<r && key>=nums[l]){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        quickSort(nums,left,l-1);
        quickSort(nums,r+1,right);
    }
}
