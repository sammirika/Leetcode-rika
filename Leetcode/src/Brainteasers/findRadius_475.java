package Brainteasers;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
 * <p>
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 */
public class findRadius_475 {

    public int findRadius(int[] houses, int[] heaters) {
        int len = houses.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0;
        for (int house : houses) {
            // 找最右端的
            while (i < heaters.length && heaters[i] < house) {
                i++;
            }
            if (i == 0) {
                radius = Math.max(radius, heaters[i] - house);
            } else if (i == heaters.length) {
                radius = Math.max(radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
            } else {
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
            }
        }
        return radius;
    }
}
