package Brainteasers;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * <p>
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。 
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 */
public class computeArea_223 {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sum1 = 0;
        int sum2 = 0;
        sum1 = (ax2 - ax1) * (ay2 - ay1);
        sum2 = (bx2 - bx1) * (by2 - by1);
        int x = 0;
        int y = 0;
        if (bx1 >= ax2 || ay1 >= by2 || ay2 <= by1 || bx2 <= ax1) {
            return sum1 + sum2;
        }
        x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        y = Math.min(ay2, by2) - Math.max(ay1, by1);
        int area = Math.max(x, 0) * Math.max(y, 0);
        return sum1 + sum2 - area;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
