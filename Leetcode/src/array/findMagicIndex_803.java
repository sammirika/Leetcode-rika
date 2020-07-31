package array;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 ***/
public class findMagicIndex_803 {

    //因为是排序数组，直接跳跃查找即可
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i)
                return i;
            i = Math.max(nums[i], i + 1);
        }
        return -1;
    }

    //这里如果是没有排序的，可以直接用treeset
    public int findMagicIndex1(int[] nums) {
        //有序set
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                set.add(nums[i]);
            }
        }
        if (set.isEmpty()) {
            return -1;
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
