/**
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 * ****/

package dandiaozhan;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        System.out.println(LargestRectangleArea.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
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
