package HuisuDigui;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 ****/
public class solveSudoku_37 {

    // 新建行数组表示数字是否在此行出现过
    boolean[][] rows = new boolean[9][9];
    // 表示是否在此列出现过
    boolean[][] cols = new boolean[9][9];
    //表示是否在对应3*3的小方块中出现过[0][0]表示第一个3*3方块，[0][1]表示第二个,[1][0]表示第四个以此类推
    boolean[][][] block = new boolean[3][3][9];
    //标志位用于回溯
    boolean flag = false;
    //list保存空格数目用于回溯结束条件
    List<int[]> res = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    res.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0' - 1;
                    rows[i][num] = cols[j][num] = block[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int index) {
        if (index == res.size()) {
            flag = true;
            return;
        }
        // 找出空格索引
        int[] xy = res.get(index);
        int x = xy[0];
        int y = xy[1];
        for (int num = 0; num < 9 && !flag; num++) {
            // 回溯
            if (!rows[x][num] && !cols[y][num] && !block[x / 3][y / 3][num]) {
                board[x][y] = (char) (num + 1 + '0');
                rows[x][num] = cols[y][num] = block[x / 3][y / 3][num] = true;
                dfs(board, index + 1);
                rows[x][num] = cols[y][num] = block[x / 3][y / 3][num] = false;
            }
        }
    }
}
