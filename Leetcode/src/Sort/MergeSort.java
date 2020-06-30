package Sort;

public class MergeSort {
    //两路归并算法，两个已经排好序的子序列并为一个子序列
    public void merge(int[] nums, int left, int mid, int right){
        //辅助数组
        int[] tmp = new int[nums.length];
        //替代指针
        int p1 = left;
        int p2 = mid+1;
        //k是存放的指针
        int k = left;
        while (p1<=mid && p2<=right){
            if (nums[p1]<nums[p2]){
                tmp[k++] = nums[p1++];
            }else {
                tmp[k++] = nums[p2++];
            }
        }
        //如果还存在没检测的直接加入
        while (p1<=mid){
            tmp[k++] = nums[p1++];
        }
        //同上
        while (p2<=right){
            tmp[k++] = nums[p2++];
        }
        //复制回原数组
        for (int i=left;i<=right;i++){
            nums[i] = tmp[i];
        }
    }

    public void mergeSort(int[] A, int start, int end){
        //递归出口
        if (start<end){
            int mid = (start+end)/2;
            //左右序列分治，与快排类似
            mergeSort(A,start,mid);
            mergeSort(A,mid+1,end);
            //归并
            merge(A,start,mid,end);
        }
    }

    public static void main(String[] args) {
        MergeSort kobe = new MergeSort();
        int[] array = new int[]{1,2,2,4,78,6,9,108,3,1,45};
        kobe.mergeSort(array,0,array.length-1);
        for (int a:array){
            System.out.println(a);
        }
    }
}
