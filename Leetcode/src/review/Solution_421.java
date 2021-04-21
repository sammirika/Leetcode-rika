package review;

import day.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_421 {

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * 示例 1:
     * <p>
     * 输入: a = 1, b = 2
     * 输出: 3
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，
     * 判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。
     * 机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。
     * 此外，假设每次移动机器人的移动幅度相同。
     * 示例 1:
     * <p>
     * 输入: "UD"
     * 输出: true
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                x++;
            } else if (ch == 'D') {
                x--;
            } else if (ch == 'L') {
                y--;
            } else if (ch == 'R') {
                y++;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * 峰值元素是指其值大于左右相邻值的元素。
     * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，
     * 在这种情况下，返回 任何一个峰值 所在位置即可。
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：2
     * 解释：3 是峰值元素，你的函数应该返回其索引 2。
     */
    public int findPeakElement(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return 0;
            } else if (i == len - 1 && nums[i] > nums[i - 1]) {
                return i;
            } else if (i > 0 && i < len - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。
     * 您可以假设数组的长度最多为10000。
     * 例如:
     * 输入:
     * [1,2,3]
     * 输出:
     * 2
     * 说明：
     * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
     * <p>
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int midNum = nums[len >> 1];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - midNum);
        }
        return res;
    }
}
