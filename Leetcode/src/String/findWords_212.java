package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 */
public class findWords_212 {
    // 暴力
    Set<String> set = new HashSet<>();
    List<String> ret = new ArrayList<>();
    char[][] boardA;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    int m;
    int n;
    boolean[][] visit = new boolean[15][15];

    public List<String> findWords(char[][] board, String[] words) {
        this.boardA = board;
        m = board.length;
        n = board[0].length;
        for (String str : words) {
            set.add(str);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                visit[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ret;
    }

    public void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) {
            return;
        }
        if (set.contains(sb.toString())) {
            ret.add(sb.toString());
            set.remove(sb.toString());
        }
        for (int x = 0; x < 4; x++) {
            int newDx = dx[x] + i;
            int newDy = dy[x] + j;
            if (newDx < 0 || newDx >= m || newDy < 0 || newDy >= n || visit[newDx][newDy]) {
                continue;
            }
            visit[newDx][newDy] = true;
            sb.append(boardA[newDx][newDy]);
            dfs(newDx, newDy, sb);
            visit[newDx][newDy] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
