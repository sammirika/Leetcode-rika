package Sreach;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 ******/

// 搜索问题，需要理解题意，这里需要进入递归的只有四周没数字或者雷的'E'
public class updateBoard_529 {

    //定义变量
    private int m;
    private int n;
    // 8个方向的坐标
    private int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        this.m = board.length;
        if (m == 0) {
            return board;
        }
        this.n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            // 进行搜索
            dfs(board, click[0], click[1], visit);
        }
        return board;
    }


    // dfs 深度优先搜索
    private void dfs(char[][] board, int x, int y, boolean[][] visit) {
        if (visit[x][y] || board[x][y] != 'E') {
            return;
        }
        visit[x][y] = true;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newDx = x + dx[i];
            int newDy = y + dy[i];
            if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || visit[newDx][newDy]) {
                continue;
            }
            if (board[newDx][newDy] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || visit[newDx][newDy]) {
                    continue;
                }
                dfs(board, newDx, newDy, visit);
            }
        }
    }


    // 广度优先搜索

    public char[][] updateBoard1(char[][] board, int[] click) {
        int m = board.length;
        if (m == 0) {
            return board;
        }
        int n = board[0].length;
        if (click[0] < 0 || click[0] >= m || click[1] < 0 || click[1] >= n) {
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[m][n];
        // 统计周围的地雷
        int count;
        // bfs
        queue.add(click);
        // 队列里只加'E'
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            // count 每次都是0
            count = 0;
            for (int i = 0; i < 8; i++) {
                int newDx = x + dx[i];
                int newDy = y + dy[i];
                if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || visited[newDx][newDy]) {
                    continue;
                }
                if (board[newDx][newDy] == 'M') {
                    count++;
                }
            }
            // 判断count
            if (count > 0) {
                board[x][y] = (char) (count + '0');
            } else {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int newDx = x + dx[i];
                    int newDy = y + dy[i];
                    if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || visited[newDx][newDy] || board[newDx][newDy] != 'E') {
                        continue;
                    }
                    queue.add(new int[]{newDx, newDy});
                    // 加入队列即代表访问过了
                    visited[newDx][newDy] = true;
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        updateBoard_529 kobe = new updateBoard_529();
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        char[][] nums = kobe.updateBoard(board, new int[]{3, 0});
        for (char[] chs : nums) {
            for (char ch : chs) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
