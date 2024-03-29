package Brainteasers;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。 
 * <p>
 * 示例 1:
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 * <p>
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 * <p>
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 */
public class validSquare_593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(getDis(p1, p2));
        set.add(getDis(p1, p3));
        set.add(getDis(p1, p4));
        set.add(getDis(p2, p3));
        set.add(getDis(p2, p4));
        set.add(getDis(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }

    private int getDis(int[] A, int[] B) {
        int a = B[0] - A[0];
        int b = B[1] - A[1];
        int dis = a * a + b * b;
        return dis;
    }
}
