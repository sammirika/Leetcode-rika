package String;

import java.util.Collections;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * ***/
public class calculate_227 {
    public static void main(String[] args) {
        System.out.println(calculate("0-2147483647"));
    }

    public static int calculate(String s) {
        //去掉所有空格
        String S = s.replaceAll(" ","");
        //定义起点
        int preIndex = 0;
        int sum = 0;
        Stack<String> stack = new Stack<>();
        //计算乘除法
        while (preIndex<S.length()){
            if (!Character.isDigit(S.charAt(preIndex))){
                stack.push(String.valueOf(S.charAt(preIndex++)));
            }
            StringBuffer num = new StringBuffer();
            //连续数字字符
            while (preIndex<S.length() && Character.isDigit(S.charAt(preIndex))){
                num.append(S.charAt(preIndex++));
            }
            //栈为空或者栈顶为+-符号可直接加入
            if (stack.empty() || stack.peek().equals("-") || stack.peek().equals("+")){
                stack.push(num.toString());
            }else if (stack.peek().equals("*")){
                stack.pop();
                int temp = Integer.parseInt(stack.pop())*Integer.parseInt(num.toString());
                stack.push(String.valueOf(temp));
            }else if (stack.peek().equals("/")){
                stack.pop();
                int temp = Integer.parseInt(stack.pop())/Integer.parseInt(num.toString());
                stack.push(String.valueOf(temp));
            }
        }
        Collections.reverse(stack);
        if (!stack.empty()){
            sum = Integer.parseInt(stack.pop());
        }
        //计算加减法,此时栈里面只有加减号了
        while (!stack.empty()){
            if (stack.pop().equals("-")){
                sum = sum - Integer.parseInt(stack.pop());
            }else {
                sum = sum + Integer.parseInt(stack.pop());
            }

        }
        return sum;
    }
}
