package tanxin;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * <p>
 * 给定数字的范围是 [0, 108]¬
 */
public class maximumSwap_670 {

    public int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        // 先找到最大数的位置下标
        char[] array = String.valueOf(num).toCharArray();
        int[] maxIndex = new int[array.length];
        int max = array.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] - '0' > array[max] - '0') {
                max = j;
            }
            // j开始算的最大索引
            maxIndex[j] = max;
        }

        // 正序遍历，找到第一个不是最大的数，直接和max互换
        for (int i = 0; i < array.length; i++) {
            int value = array[i] - '0';
            int maxValue = array[maxIndex[i]] - '0';
            if (value != maxValue) {
                array[i] = (char) (maxValue + '0');
                array[maxIndex[i]] = (char) (value + '0');
                break;
            }
        }
        return Integer.parseInt(new String(array));
    }
}
