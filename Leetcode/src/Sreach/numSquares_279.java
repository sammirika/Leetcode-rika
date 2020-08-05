package Sreach;

import java.util.*;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 ****/
public class numSquares_279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }


    //转换成最小路径问题
    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 0; i * i <= n; i++) {
            squares.add(i * i);
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        //bfs
        while (queue.size() > 0) {
            level++;
            Set<Integer> set = new HashSet<>();
            for (int temp : queue) {
                for (int square : squares) {
                    if (temp == square) {
                        return level;
                    } else if (temp < square) {
                        break;
                    }
                    set.add(temp - square);
                }
            }
            queue = set;
        }
        return level;
    }
}
