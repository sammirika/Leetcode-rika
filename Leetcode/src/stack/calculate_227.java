package stack;

import java.util.Collections;
import java.util.Stack;

/***
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * */
public class calculate_227 {

    public int calculate(String s) {
        // 先排除空格
        s = s.replaceAll(" ", "");
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                stack.push(String.valueOf(cur));
            } else if (ch == '-' || ch == '+') {
                stack.push(String.valueOf(ch));
            } else if (ch == '*') {
                int cur = 0;
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                int num = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num * cur));
            } else if (ch == '/') {
                int cur = 0;
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                int num = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num / cur));
            }
        }
        // 反序
        Collections.reverse(stack);
        if (stack.isEmpty()) {
            return 0;
        }
        int res = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            if (stack.peek().equals("-")) {
                stack.pop();
                res = res - Integer.parseInt(stack.pop());
            } else if (stack.peek().equals("+")) {
                stack.pop();
                res = res + Integer.parseInt(stack.pop());
            }
        }
        return res;
    }
}
