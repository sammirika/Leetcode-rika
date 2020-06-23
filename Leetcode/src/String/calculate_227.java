package String;

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
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        //去掉所有空格
        s = s.replaceAll(" ","");
        //定义起点
        int preIndex = 0;
        int sum = 0;
        Stack<String> stack = new Stack<>();
        while (preIndex<s.length()){
            StringBuffer str = new StringBuffer();
            while (preIndex<s.length() && Character.isDigit(s.charAt(preIndex))){
                str.append(s.charAt(preIndex));
                preIndex++;
            }
            if (!str.equals("")){
                stack.push(str.toString());
                continue;
            }
            if (s.charAt(preIndex)=='*'){
                preIndex++;
                StringBuffer temp = new StringBuffer();
                while (preIndex<s.length() && Character.isDigit(s.charAt(preIndex))){
                    temp.append(s.charAt(preIndex++));
                }
                sum = Integer.parseInt(stack.pop()) * Integer.parseInt(temp.toString());
                System.out.println(sum);
                //再把乘积入栈
                stack.push(String.valueOf(sum));
                continue;
            }
            if (s.charAt(preIndex)=='/'){
                preIndex++;
                StringBuffer temp = new StringBuffer();
                while (preIndex<s.length() && Character.isDigit(s.charAt(preIndex))){
                    temp.append(s.charAt(preIndex++));
                }
                sum = Integer.parseInt(stack.pop()) / Integer.parseInt(temp.toString());
                System.out.println(sum);
                //再把余数入栈
                stack.push(String.valueOf(sum));
                continue;
            }
        }
        if (!stack.empty()){
            sum = Integer.parseInt(stack.pop());
        }
        while (!stack.empty()){
            if (stack.pop().equals("+")){
                sum = sum + Integer.parseInt(stack.pop());
            }else {
                sum = Integer.parseInt(stack.pop()) - sum;
            }
        }
        return sum;
    }
}
