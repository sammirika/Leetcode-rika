package Brainteasers;


/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 */
public class longestMountain_845 {

    public static int longestMountain(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        right[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = A[i] > A[i + 1] ? right[i + 1] + 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] != 0 && right[i] != 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
