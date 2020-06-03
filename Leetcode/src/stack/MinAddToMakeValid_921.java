package stack;

import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数
 *
 * 输入："()))(("
 * 输出：4
 *
 * **/
public class MinAddToMakeValid_921 {

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("((("));
    }

    public static int minAddToMakeValid(String S) {
        //新建一个栈，存放字符
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char[] array = S.toCharArray();
        for(char a:array){
            if (a=='('){
                stack.push(a);
            }else if(a==')' && !stack.empty()) {
                stack.pop();
            }else if(a==')' && stack.empty()) {
                count++;
            }
        }
        return count+stack.size();
    }
}
