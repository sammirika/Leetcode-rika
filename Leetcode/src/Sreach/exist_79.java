package Sreach;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * *****/
public class exist_79 {

    //回溯，也就是深度优先搜索
    private int[] dx = new int[]{-1,1,0,0};
    private int[] dy = new int[]{0,0,-1,1};

    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        if (m==0){
            return false;
        }
        this.n = board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(board,0,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int index,int x,int y,String word){
        if (x<0 || x>=m || y<0 || y>=n || board[x][y] != word.charAt(index)){
            return false;
        }
        if (index == word.length()-1){
            return true;
        }
        //把遍历过的board中的点更换
        board[x][y] = '#';
        //上下左右遍历
        for (int i=0;i<4;i++){
            int newDx = x + dx[i];
            int newDy = y + dy[i];
            if (dfs(board,index+1,newDx,newDy,word)){
                return true;
            }
        }
        //回溯
        //还原
        board[x][y] = word.charAt(index);
        return false;
    }
}
