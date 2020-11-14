package Sort;


import java.util.*;

/***
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * ***/
public class relativeSortArray_1122 {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] hash = new int[1001];
        // 找到array2中元素的相对位置
        for (int i = 0; i < arr2.length; i++) {
            hash[arr2[i]] = i;
            set.add(arr2[i]);
        }
        // 利用相对位置排序
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                list1.add(arr1[i]);
            } else {
                list2.add(arr1[i]);
            }
        }
        // 按相对位置排
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hash[o1] - hash[o2];
            }
        });
        Collections.sort(list2);
        for (int num : list2) {
            list1.add(num);
        }
        int[] res = new int[list1.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list1.get(i);
        }
        return res;
    }
}
