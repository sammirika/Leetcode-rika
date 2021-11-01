package Brainteasers;

import java.util.*;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * 示例 1:
 * <p>
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 * <p>
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 */
public class distributeCandies_575 {

    public static int distributeCandies(int[] candyType) {
        // hash
        Map<Integer, Integer> map = new TreeMap<>();
        // 按values值升序的优先队列
        for (int candy : candyType) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        // 分得的糖果树目
        int num = candyType.length / 2;
        if (num < map.size()) {
            return num;
        } else {
            return map.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies_575.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
