package kexin;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Sloution_1101 {


    /***
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 例如，
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * 示例 1:
     *
     * 输入: 1
     * 输出: "A"
     * ***/
    public static String convertToTitle(int n) {
        Stack<String> stack = new Stack<>();
        // 使用栈来解决
        while (n != 0) {
            n -= 1;
            stack.push(String.valueOf(n % 26));
            n /= 26;
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append((char) (Integer.parseInt(stack.pop()) + 65));
        }
        return str.toString();
    }


    /***
     * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
     * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
     * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
     * 示例 1:
     *
     * 输入: [[0,2],[1,3]]
     * 输出: 3
     * 解释:
     * 时间为0时，你位于坐标方格的位置为 (0, 0)。
     * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
     *
     * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
     * 示例2:
     *
     * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
     * 输出: 16
     * 解释:
     *  0  1  2  3  4
     * 24 23 22 21  5
     * 12 13 14 15 16
     * 11 17 18 19 20
     * 10  9  8  7  6
     *
     * 最终的路线用加粗进行了标记。
     * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
     * ***/
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 使用优先队列
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[][] visit = new boolean[m][n];
        queue.add(new int[]{0, 0, grid[0][0]});
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int res = xy[2];
            visit[x][y] = true;
            if (x == m - 1 && y == n - 1) {
                return res;
            }
            for (int i = 0; i < 4; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx >= 0 && newDy >= 0 && newDx < m && newDy < n && !visit[newDx][newDy]) {
                    int max = Math.max(res, grid[newDx][newDy]);
                    queue.add(new int[]{newDx, newDy, max});
                }
            }
        }
        return -1;
    }


    /****
     * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     * 任何左括号 ( 必须有相应的右括号 )。
     * 任何右括号 ) 必须有相应的左括号 ( 。
     * 左括号 ( 必须在对应的右括号之前 )。
     * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
     * 一个空字符串也被视为有效字符串。
     * 示例 1:
     *
     * 输入: "()"
     * 输出: True
     * 示例 2:
     *
     * 输入: "(*)"
     * 输出: True
     * *****/
    public boolean checkValidString(String s) {
        // 使用区间贪心
        if (s.length() < 1) {
            return true;
        }
        int min = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                if (min > 0){
                    min--;
                }
                if (max-- == 0){
                    return false;
                }
            } else {
                if (min > 0) {
                    min--;
                }
                max++;
            }
        }
        return min == 0;
    }


    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
}
