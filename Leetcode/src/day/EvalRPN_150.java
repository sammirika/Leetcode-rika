package day;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 *
 * *****/


public class EvalRPN_150 {
    //全局变量求和
    int sum;

    public static void main(String[] args) {
        EvalRPN_150 kobe = new EvalRPN_150();
        String[] token = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(kobe.evalRPN(token));
    }

    //考虑用栈来解决，每次遇到标点符号进行对应运算
    public int evalRPN(String[] tokens) {
        this.sum = 0;
        //定义下标
        int preindex = 0;
        Stack<String> stack = new Stack<>();
        while (preindex<tokens.length){
            if (tokens[preindex]!="+" && tokens[preindex]!="-" && tokens[preindex]!="*" && tokens[preindex]!="/"){
                stack.push(tokens[preindex]);
            }else if (tokens[preindex].equals("+")){
                addition(stack);
            }else if (tokens[preindex].equals("-")){
                subtraction(stack);
            }else if (tokens[preindex].equals("*")){
                multiplication(stack);
            }else if (tokens[preindex].equals("/")){
                division(stack);
            }
            preindex++;
        }
        return Integer.parseInt(stack.peek());
    }

    //加法
    private void addition(Stack<String> stack){
        int A = Integer.parseInt(stack.pop());
        int B = Integer.parseInt(stack.pop());
        sum = A+B;
        stack.push(String.valueOf(sum));
    }

    //减法
    private void subtraction(Stack<String> stack){
        int A = Integer.parseInt(stack.pop());
        int B = Integer.parseInt(stack.pop());
        sum = B-A;
        stack.push(String.valueOf(sum));
    }
    //乘法
    private void multiplication(Stack<String> stack){
        int A = Integer.parseInt(stack.pop());
        int B = Integer.parseInt(stack.pop());
        sum = B*A;
        stack.push(String.valueOf(sum));
    }

    //除法
    private void division(Stack<String> stack){
        int A = Integer.parseInt(stack.pop());
        int B = Integer.parseInt(stack.pop());
        sum = B/A;
        stack.push(String.valueOf(sum));
    }
}
