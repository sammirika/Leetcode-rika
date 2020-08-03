package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *  
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * *****/
public class evalRPN_150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        for (String str:tokens){
            if (!list.contains(str)){
                stack.push(str);
            }else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(getSum(a,b,str));
            }
        }
        return Integer.parseInt(stack.peek());
    }

    //方便再次入栈，这里直接就用String类型了
    private String getSum(String a, String b, String c) {
        Integer sum = 0;
        if (c.equals("+")) {
            sum = Integer.parseInt(a) + Integer.parseInt(b);
        }
        if (c.equals("-")) {
            sum = Integer.parseInt(a) - Integer.parseInt(b);
        }
        if (c.equals("*")) {
            sum = Integer.parseInt(a) * Integer.parseInt(b);
        }
        if (c.equals("/")) {
            sum = Integer.parseInt(a) / Integer.parseInt(b);
        }
        return sum.toString();
    }
}
