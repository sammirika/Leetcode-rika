package dandiaozhan;

import java.util.Stack;

/***
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * ******/
public class maximalRectangle_85 {

    // 转化为每一行的柱状图求最大矩形
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int len = matrix[0].length;
        int[] dp = new int[len];
        int res = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<len;j++){
                if (matrix[i][j] == '1'){
                    dp[j] = dp[j] + 1;
                }else {
                    dp[j] = 0;
                }
            }
            res = Math.max(res,largestRectangleArea(dp));
        }
        return res;
    }

    // 单调栈求柱状图最大矩形面积
    public  int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty() && heights[i]<heights[stk.peek()]){
                int index = stk.pop();
                int h = heights[index];
                int w = i - (stk.isEmpty()? 0:stk.peek()+1);
                res = Math.max(res,h*w);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int index = stk.pop();
            int h = heights[index];
            int w = heights.length - (stk.isEmpty()? 0:stk.peek()+1);
            res = Math.max(res,h*w);
        }
        return res;
    }
}
