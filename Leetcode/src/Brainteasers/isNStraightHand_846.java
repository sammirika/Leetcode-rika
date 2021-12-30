package Brainteasers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，
 * 并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。
 * 如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 */
public class isNStraightHand_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        // 利用hash贪心
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 贪心迭代
        for (int x : hand) {
            if (!map.containsKey(x)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int num = i + x;
                if (!map.containsKey(num)) {
                    return false;
                }
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return true;
    }
}
