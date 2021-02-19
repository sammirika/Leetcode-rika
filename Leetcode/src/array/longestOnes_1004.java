package array;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 **/
public class longestOnes_1004 {

    //滑动窗口
    public int longestOnes(int[] A, int K) {
        int l = 0;
        int res = 0;
        int zeroCount = 0;
        for (int r = 0; r < A.length; r++) {
            if (A[r] == 0) {
                zeroCount++;
            }
            while (zeroCount > K) {
                if (A[l] == 0) {
                    zeroCount--;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
