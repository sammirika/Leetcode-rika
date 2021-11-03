package Brainteasers;

import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class smallestK_1714 {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.offer(num);
        }
        int[] ret = new int[k];
        int index = 0;
        while (k > 0) {
            ret[index++] = queue.poll();
            k--;
        }
        return ret;
    }
}
