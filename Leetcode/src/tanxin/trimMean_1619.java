package tanxin;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出：4.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class trimMean_1619 {

    public double trimMean(int[] arr) {
        int len = arr.length;
        // 需要删除的数字
        int deleteCount = (int) (len * 0.05);
        Arrays.sort(arr);
        int total = 0;
        int end = arr.length - 1 - deleteCount;
        for (int i = deleteCount; i <= end; i++) {
            total += arr[i];
        }
        return (double) total / (arr.length - 2 * deleteCount);
    }
}
