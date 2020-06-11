package day;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * ********/
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] array = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int a:array){
            System.out.println(a);
        }
    }

    //6.11的每日一題，單調棧求解
    public static int[] dailyTemperatures(int[] T) {
        //返回的數組
        int[] num = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=T.length-1;i>=0;i--){
            //从后往前单调递减，每次遇到比栈顶大的就出栈，直到遇到栈顶比这个数大或者空栈
            while (!stack.empty() && T[i]>=T[stack.peek()]){
                stack.pop();
            }
            num[i] = stack.empty()? 0: stack.peek()-i;
            stack.push(i);
        }
        return num;
    }
}
