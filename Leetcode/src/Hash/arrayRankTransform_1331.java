package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 */
public class arrayRankTransform_1331 {


    public static int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arrayCopy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(arrayCopy);
        int index = 1;
        for (int i = 0; i < arrayCopy.length; i++) {
            if (!map.containsKey(arrayCopy[i])) {
                map.put(arrayCopy[i], index);
                index++;
            }
        }
        int[] ret = new int[arr.length];
        int a = 0;
        for (int num : arr) {
            ret[a++] = map.get(num);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] temp = arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12,5});
        for (int num : temp) {
            System.out.println(num);
        }
    }
}
