package array;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 *
 * ****/
public class divingBoard_1611 {

    public static void main(String[] args) {
        int[] nums = divingBoard(1,2,3);
        for (int A:nums){
            System.out.println(A);
        }
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k==0){
            return new int[]{};
        }
        if (shorter==longer){
            return new int[]{shorter*k};
        }
        int tmp = 0;
        int[] nums = new int[k+1];
        while (tmp<=k){
            nums[tmp] = shorter*(k-tmp) + longer*(tmp);
            tmp++;
        }
        return nums;
    }
}
