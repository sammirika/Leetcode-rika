package Dp;


/***
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * ****/
public class longestMountain_845 {

    public static int longestMountain(int[] A) {
        // 求出左右分别的count值，用两个数组
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] left = new int[len];
        // 求出每个元素左右分别大于和小于的count数目
        for (int i = 1; i < len; i++) {
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[len];
        for (int i = len - 2; i >= 1; i--) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (left[i] > 0 && right[i] > 0) {
                res = Math.max(res, right[i] + left[i] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
