package day;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * ***/
public class MinIncrementForUnique_945 {

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    public static int minIncrementForUnique(int[] A) {
        //先将数组排序
        Arrays.sort(A);
        int res = 0;
        for(int i=1;i<A.length;i++){
            //如果当前数小于等于前一个数，将现有的数变为前一个数+1，因为相对有序
            if (A[i]<=A[i-1]){
                int pre = A[i];
                A[i] = A[i-1] + 1;
                res += A[i] - pre;
            }
        }
        return res;
    }
}
