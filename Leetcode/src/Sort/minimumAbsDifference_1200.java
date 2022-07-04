package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 */
public class minimumAbsDifference_1200 {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) < minDiff) {
                lists.clear();
                minDiff = arr[i + 1] - arr[i];
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
            } else if ((arr[i + 1] - arr[i]) == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDifference(num));
    }
}
