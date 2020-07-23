package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 ******/
public class fourSumCount_454 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(fourSumCount(A, B, C, D));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //使用hash表解决
        Map<Integer, Integer> map = new HashMap<>();
        //把C，D的值映射到表中,组合形式多少次由value决定
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = C[i] + D[j];
                if (map.containsKey(sumCD)) {
                    map.put(sumCD, map.get(sumCD) + 1);
                } else {
                    map.put(sumCD, 1);
                }
            }
        }
        //目标次数
        int res = 0;
        for (int m = 0; m < A.length; m++) {
            for (int n = 0; n < B.length; n++) {
                int temp = 0 - A[m] - B[n];
                if (map.containsKey(temp)) {
                    res += map.get(temp);
                }
            }
        }
        return res;
    }
}
