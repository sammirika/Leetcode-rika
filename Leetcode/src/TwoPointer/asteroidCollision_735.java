package TwoPointer;

import java.util.Stack;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
 * 每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 *  
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 */
public class asteroidCollision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        // 栈模拟,只有左星大于0，右星小于0的情况会发生碰撞
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < asteroids.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[index] > 0) {
                stack.push(asteroids[index]);
            } else if (stack.peek() == -asteroids[index]) {
                stack.pop();
            } else if (stack.peek() < -asteroids[index]) {
                stack.pop();
                continue;
            }
            index++;
        }
        int[] ret = new int[stack.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
